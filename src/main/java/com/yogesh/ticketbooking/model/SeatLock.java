package com.yogesh.ticketbooking.model;

import lombok.*;

import java.time.*;
import java.util.*;

@AllArgsConstructor
@Getter
public class SeatLock {
  private Seat seat;
  private Show show;
  private Integer timeoutInSeconds;
  private Date lockTime;
  private String lockedBy;

  public boolean isLockExpired() {
    final Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutInSeconds);
    final Instant currentInstant = new Date().toInstant();
    return lockInstant.isBefore(currentInstant);
  }
}
