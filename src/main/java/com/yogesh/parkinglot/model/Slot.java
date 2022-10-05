package com.yogesh.parkinglot.model;

import lombok.Getter;

public class Slot {

  @Getter private Integer slotNumber;
  @Getter private Car parkedCar;

  public Slot(final Integer slotNumber) {
    this.slotNumber = slotNumber;
  }

  public Integer getSlotNumber() {
    return slotNumber;
  }

  public Car getParkedCar() {
    return parkedCar;
  }

  public boolean isSlotFree() {
    return parkedCar == null;
  }

  public void assignCar(Car car) {
    this.parkedCar = car;
  }

  public void unassignCar() {
    this.parkedCar = null;
  }
}
