package com.yogesh.parkinglot.strategy;

public interface ParkingStrategy {
  /**
   * Add a new slot to parking strategy. After adding, this new slot will become available for
   * future parkings.
   *
   * @param slotNumber Slot number to be added.
   */
  void addSlot(Integer slotNumber);

  /**
   * Removes a slot from the parking strategy. After removing, this slot will not be used for future
   * parkings.
   *
   * @param slotNumber Slot number to be removed.
   */
  void removeSlot(Integer slotNumber);

  /**
   * Get the next free slot as per the parking strategy.
   *
   * @return Next free slot number.
   */
  Integer getNextSlot();
}
