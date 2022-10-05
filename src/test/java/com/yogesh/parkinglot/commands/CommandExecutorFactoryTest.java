package com.yogesh.parkinglot.commands;

import com.yogesh.parkinglot.exception.*;
import com.yogesh.parkinglot.model.*;
import com.yogesh.parkinglot.service.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CommandExecutorFactoryTest {

  private CommandExecutorFactory factory;

  @BeforeAll
  public void setUp() throws Exception {
    final ParkingLotService parkingLotService = mock(ParkingLotService.class);
    factory = new CommandExecutorFactory(parkingLotService);
  }

  @Test
  public void testFetchingExecutorForValidCommand() {
    final CommandExecutor commandExecutor = factory.getCommandExecutor(new Command("leave 1"));
    assertNotNull(commandExecutor);
    assertTrue(commandExecutor instanceof LeaveCommandExecutor);
  }

  @Test /*(expected = InvalidCommandException.class)*/
  public void testFetchingExecutorForInvalidCommand() {
    assertThrows(
        InvalidCommandException.class,
        () ->
            factory.getCommandExecutor(
                new Command("some-random-command random-param1 random-param2")));
    //    factory.getCommandExecutor(new Command("some-random-command random-param1
    // random-param2"));
  }
}
