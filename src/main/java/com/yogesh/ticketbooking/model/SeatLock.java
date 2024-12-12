package com.yogesh.ticketbooking.model;

import lombok.*;

import java.time.*;
import java.util.*;

@RequiredArgsConstructor
@Getter
public class SeatLock {
  private final Seat seat;
  private final Show show;
  private final Integer timeoutInSeconds;
  private final Date lockTime;
  private final String lockedBy;

  public boolean isLockExpired() {
    final Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutInSeconds);
    final Instant currentInstant = new Date().toInstant();
    return lockInstant.isAfter(currentInstant);
  }
}
