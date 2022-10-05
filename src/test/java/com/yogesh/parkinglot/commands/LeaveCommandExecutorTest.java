package com.yogesh.parkinglot.commands;

import com.yogesh.parkinglot.OutputPrinter;
import com.yogesh.parkinglot.model.Command;
import com.yogesh.parkinglot.service.ParkingLotService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class LeaveCommandExecutorTest {

  private ParkingLotService parkingLotService;
  private OutputPrinter outputPrinter;
  private LeaveCommandExecutor leaveCommandExecutor;

  @BeforeAll
  public void setUp() throws Exception {
    parkingLotService = mock(ParkingLotService.class);
    outputPrinter = mock(OutputPrinter.class);
    leaveCommandExecutor = new LeaveCommandExecutor(parkingLotService, outputPrinter);
  }

  @Test
  public void testValidCommand() {
    assertTrue(leaveCommandExecutor.validate(new Command("leave 1")));
  }

  @Test
  public void testInvalidCommand() {
    assertFalse(leaveCommandExecutor.validate(new Command("leave")));
    assertFalse(leaveCommandExecutor.validate(new Command("leave 1 2")));
    assertFalse(leaveCommandExecutor.validate(new Command("leave 1 a")));
    assertFalse(leaveCommandExecutor.validate(new Command("leave abcd")));
  }

  @Test
  public void testLeavingCarFromSlotMakesSlotFreeFromParkingService() {
    leaveCommandExecutor.execute(new Command("leave 1"));
    verify(parkingLotService).makeSlotFree(1);
    verify(outputPrinter).printWithNewLine("Slot number 1 is free");
  }
}
