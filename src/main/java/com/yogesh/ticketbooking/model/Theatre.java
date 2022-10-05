package com.yogesh.ticketbooking.model;

import lombok.*;

import java.util.*;

@Getter
public class Theatre {
  private final String id;
  private final String name;
  private final List<Screen> screens;
  // Other theatre metadata.

  public Theatre(@NonNull final String id, @NonNull final String name) {
    this.id = id;
    this.name = name;
    this.screens = new ArrayList<>();
  }

  public void addScreen(@NonNull final Screen screen) {
    screens.add(screen);
  }
}
