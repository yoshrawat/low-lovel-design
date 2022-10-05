package com.yogesh.parkinglot.commands;

import com.yogesh.parkinglot.OutputPrinter;
import com.yogesh.parkinglot.model.Command;
import com.yogesh.parkinglot.model.ParkingLot;
import com.yogesh.parkinglot.service.ParkingLotService;
import com.yogesh.parkinglot.strategy.NaturalOrderingParkingStrategy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateParkingLotCommandExecutorTest {
  private ParkingLotService parkingLotService;
  private OutputPrinter outputPrinter;
  private CreateParkingLotCommandExecutor createParkingLotCommandExecutor;

  @BeforeAll
  public void setUp() throws Exception {
    parkingLotService = mock(ParkingLotService.class);
    outputPrinter = mock(OutputPrinter.class);
    createParkingLotCommandExecutor =
        new CreateParkingLotCommandExecutor(parkingLotService, outputPrinter);
  }

  @Test
  public void testValidCommand() {
    assertTrue(createParkingLotCommandExecutor.validate(new Command("create_parking_lot 6")));
  }

  @Test
  public void testInvalidCommand() {
    assertFalse(createParkingLotCommandExecutor.validate(new Command("create_parking_lot")));
    assertFalse(createParkingLotCommandExecutor.validate(new Command("create_parking_lot abcd")));
  }

  @Test
  public void testCommandExecution() {
    createParkingLotCommandExecutor.execute(new Command("create_parking_lot 6"));

    final ArgumentCaptor<ParkingLot> argument = ArgumentCaptor.forClass(ParkingLot.class);
    verify(parkingLotService)
        .createParkingLot(argument.capture(), any(NaturalOrderingParkingStrategy.class));
    assertEquals(6, argument.getValue().getCapacity());
    verify(outputPrinter).printWithNewLine("Created a parking lot with 6 slots");
  }
}
