package com.yogesh.parkinglot.commands;

import com.yogesh.parkinglot.OutputPrinter;
import com.yogesh.parkinglot.model.Car;
import com.yogesh.parkinglot.model.Command;
import com.yogesh.parkinglot.model.Slot;
import com.yogesh.parkinglot.service.ParkingLotService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class StatusCommandExecutorTest {
  private ParkingLotService parkingLotService;
  private OutputPrinter outputPrinter;
  private StatusCommandExecutor statusCommandExecutor;

  @BeforeAll
  public void setUp() throws Exception {
    parkingLotService = mock(ParkingLotService.class);
    outputPrinter = mock(OutputPrinter.class);
    statusCommandExecutor = new StatusCommandExecutor(parkingLotService, outputPrinter);
  }

  @Test
  public void testValidCommand() {
    assertTrue(statusCommandExecutor.validate(new Command("status")));
  }

  @Test
  public void testInvalidCommand() {
    assertFalse(statusCommandExecutor.validate(new Command("status 1")));
    assertFalse(statusCommandExecutor.validate(new Command("status 2 3")));
  }

  @Test
  public void testCommandExecutionWhenParkingLotIsEmpty() {
    List<Slot> occupiedSlots = new ArrayList<>();
    when(parkingLotService.getOccupiedSlots()).thenReturn(occupiedSlots);
    statusCommandExecutor.execute(new Command("status"));
    verify(parkingLotService).getOccupiedSlots();
    verify(outputPrinter).parkingLotEmpty();
  }

  @Test
  public void testCommandExecutionWithOccupiedParkingLot() {
    final Slot slot1 = new Slot(1);
    slot1.assignCar(new Car("reg-1", "white"));

    final Slot slot2 = new Slot(2);
    slot2.assignCar(new Car("reg-2", "blue"));

    when(parkingLotService.getOccupiedSlots()).thenReturn(Arrays.asList(slot1, slot2));

    statusCommandExecutor.execute(new Command("status"));

    verify(parkingLotService).getOccupiedSlots();
    verify(outputPrinter).statusHeader();
    verify(outputPrinter).printWithNewLine("1           reg-1              white");
    verify(outputPrinter).printWithNewLine("2           reg-2              blue");
  }
}
