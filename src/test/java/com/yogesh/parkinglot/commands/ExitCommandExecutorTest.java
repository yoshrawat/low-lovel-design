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

public class ExitCommandExecutorTest {
  private ParkingLotService parkingLotService;
  private OutputPrinter outputPrinter;
  private ExitCommandExecutor exitCommandExecutor;

  @BeforeAll
  public void setUp() throws Exception {
    parkingLotService = mock(ParkingLotService.class);
    outputPrinter = mock(OutputPrinter.class);
    exitCommandExecutor = new ExitCommandExecutor(parkingLotService, outputPrinter);
  }

  @Test
  public void testValidCommand() {
    assertTrue(exitCommandExecutor.validate(new Command("exit")));
  }

  @Test
  public void testInvalidCommand() {
    assertFalse(exitCommandExecutor.validate(new Command("exit 1")));
    assertFalse(exitCommandExecutor.validate(new Command("exit 1 2")));
    assertFalse(exitCommandExecutor.validate(new Command("exit a")));
  }

  @Test
  public void textCommandExecution() {
    exitCommandExecutor.execute(new Command("exit"));
    verify(outputPrinter).end();
  }
}
