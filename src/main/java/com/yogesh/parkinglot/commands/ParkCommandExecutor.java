package com.yogesh.parkinglot.commands;

import com.yogesh.parkinglot.*;
import com.yogesh.parkinglot.exception.*;
import com.yogesh.parkinglot.model.*;
import com.yogesh.parkinglot.service.*;

/**
 * Executor to handle command of parking a car into the parking lot. This outputs the allocated slot
 * in which the car is parked.
 */
public class ParkCommandExecutor extends CommandExecutor {
  public static String COMMAND_NAME = "park";

  public ParkCommandExecutor(
      final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
    super(parkingLotService, outputPrinter);
  }

  /** {@inheritDoc} */
  @Override
  public boolean validate(final Command command) {
    return command.getParams().size() == 2;
  }

  /** {@inheritDoc} */
  @Override
  public void execute(final Command command) {
    final Car car = new Car(command.getParams().get(0), command.getParams().get(1));
    try {
      final Integer slot = parkingLotService.park(car);
      outputPrinter.printWithNewLine("Allocated slot number: " + slot);
    } catch (NoFreeSlotAvailableException exception) {
      outputPrinter.parkingLotFull();
    }
  }
}
