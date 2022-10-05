package com.yogesh.ticketbooking.model;

import lombok.*;

import java.util.*;

@AllArgsConstructor
@Getter
public class Show {
  private final String id;
  private final Movie movie;
  private final Screen screen;
  private final Date startTime;
  private final Integer durationInSeconds;
}
