package com.yogesh.parkinglot.model;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Car {
  @Getter private String registrationNumber;
  @Getter private String color;
  public Car(final String registrationNumber, final String color) {
    this.registrationNumber = registrationNumber;
    this.color = color;
  }
}
