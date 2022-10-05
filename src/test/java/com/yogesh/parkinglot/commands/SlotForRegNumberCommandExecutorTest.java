package com.yogesh.parkinglot.commands;

import com.yogesh.parkinglot.OutputPrinter;
import com.yogesh.parkinglot.model.Car;
import com.yogesh.parkinglot.model.Command;
import com.yogesh.parkinglot.model.Slot;
import com.yogesh.parkinglot.service.ParkingLotService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlotForRegNumberCommandExecutorTest {

  private ParkingLotService parkingLotService;
  private OutputPrinter outputPrinter;
  private SlotForRegNumberCommandExecutor slotForRegNumberCommandExecutor;

  @BeforeAll
  public void setUp() throws Exception {
    parkingLotService = mock(ParkingLotService.class);
    outputPrinter = mock(OutputPrinter.class);
    slotForRegNumberCommandExecutor =
        new SlotForRegNumberCommandExecutor(parkingLotService, outputPrinter);
  }

  @Test
  public void testValidCommand() {
    assertTrue(
        slotForRegNumberCommandExecutor.validate(
            new Command("slot_number_for_registration_number AB-01-CP-1230")));
  }

  @Test
  public void testInvalidCommand() {
    assertFalse(
        slotForRegNumberCommandExecutor.validate(
            new Command("slot_number_for_registration_number")));
    assertFalse(
        slotForRegNumberCommandExecutor.validate(
            new Command("slot_number_for_registration_number AB-01-CP-1230 b")));
  }

  @Test
  public void testCorrectSlotNumberForValidRegistrationNumber() {
    final Slot slot1 = new Slot(1);
    slot1.assignCar(new Car("reg-1", "white"));

    final Slot slot2 = new Slot(2);
    slot2.assignCar(new Car("AB-01-CP-1230", "blue"));

    final Slot slot3 = new Slot(3);
    slot3.assignCar(new Car("reg-2", "blue"));

    when(parkingLotService.getOccupiedSlots()).thenReturn(Arrays.asList(slot1, slot2, slot3));

    slotForRegNumberCommandExecutor.execute(
        new Command("slot_number_for_registration_number AB-01-CP-1230"));
    verify(outputPrinter).printWithNewLine("2");
  }

  @Test
  public void testCorrectSlotNumberForNonExistingRegistrationNumber() {
    List<Slot> occupiedSlots = new ArrayList<>();
    when(parkingLotService.getOccupiedSlots()).thenReturn(occupiedSlots);

    slotForRegNumberCommandExecutor.execute(
        new Command("slot_number_for_registration_number AB-01-CP-1230"));
    verify(outputPrinter).notFound();
  }
}
