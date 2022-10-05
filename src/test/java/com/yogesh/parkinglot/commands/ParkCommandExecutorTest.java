package com.yogesh.parkinglot.commands;

import com.yogesh.parkinglot.*;
import com.yogesh.parkinglot.exception.*;
import com.yogesh.parkinglot.model.*;
import com.yogesh.parkinglot.service.*;
import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class ParkCommandExecutorTest {
  private ParkingLotService parkingLotService;
  private OutputPrinter outputPrinter;
  private ParkCommandExecutor parkCommandExecutor;

  @BeforeAll
  public void setUp() throws Exception {
    parkingLotService = mock(ParkingLotService.class);
    outputPrinter = mock(OutputPrinter.class);
    parkCommandExecutor = new ParkCommandExecutor(parkingLotService, outputPrinter);
  }

  @Test
  public void testValidCommand() {
    assertTrue(parkCommandExecutor.validate(new Command("park test-command-number white")));
  }

  @Test
  public void testInvalidCommand() {
    assertFalse(parkCommandExecutor.validate(new Command("park")));
    assertFalse(parkCommandExecutor.validate(new Command("park test-car-number")));
    assertFalse(parkCommandExecutor.validate(new Command("park test-car-number white abcd")));
  }

  @Test
  public void testCommandExecutionWhenParkingSucceeds() {
    when(parkingLotService.park(any())).thenReturn(1);
    parkCommandExecutor.execute(new Command("park test-car-number white"));

    final ArgumentCaptor<Car> argument = ArgumentCaptor.forClass(Car.class);
    verify(parkingLotService).park(argument.capture());
    assertEquals("test-car-number", argument.getValue().getRegistrationNumber());
    assertEquals("white", argument.getValue().getColor());

    verify(outputPrinter).printWithNewLine("Allocated slot number: 1");
  }

  @Test
  public void testCommandExecutionWhenParkingIsFull() {
    when(parkingLotService.park(any())).thenThrow(new NoFreeSlotAvailableException());
    parkCommandExecutor.execute(new Command("park test-car-number white"));

    final ArgumentCaptor<Car> argument = ArgumentCaptor.forClass(Car.class);
    verify(parkingLotService).park(argument.capture());
    assertEquals("test-car-number", argument.getValue().getRegistrationNumber());
    assertEquals("white", argument.getValue().getColor());

    verify(outputPrinter).parkingLotFull();
  }
}
