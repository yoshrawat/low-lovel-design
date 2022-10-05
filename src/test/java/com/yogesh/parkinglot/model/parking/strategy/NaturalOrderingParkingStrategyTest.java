package com.yogesh.parkinglot.model.parking.strategy;

import com.yogesh.parkinglot.exception.NoFreeSlotAvailableException;
import com.yogesh.parkinglot.strategy.NaturalOrderingParkingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NaturalOrderingParkingStrategyTest {
  private final NaturalOrderingParkingStrategy naturalOrderingParkingStrategy =
      new NaturalOrderingParkingStrategy();

  @Test
  public void testValidStrategyExecution() {
    naturalOrderingParkingStrategy.addSlot(1);
    naturalOrderingParkingStrategy.addSlot(2);
    naturalOrderingParkingStrategy.addSlot(3);

    assertEquals((Integer) 1, naturalOrderingParkingStrategy.getNextSlot());
    naturalOrderingParkingStrategy.removeSlot(2);
    assertEquals((Integer) 1, naturalOrderingParkingStrategy.getNextSlot());
    naturalOrderingParkingStrategy.removeSlot(1);
    assertEquals((Integer) 3, naturalOrderingParkingStrategy.getNextSlot());
    naturalOrderingParkingStrategy.addSlot(2);
    assertEquals((Integer) 2, naturalOrderingParkingStrategy.getNextSlot());
  }

  @Test
  public void testFullParkingStrategy() {
    assertThrows(
        NoFreeSlotAvailableException.class, naturalOrderingParkingStrategy::getNextSlot);
  }
}
