package com.yogesh.flightbooking.model;

import lombok.*;

import java.time.*;
import java.util.*;

@Getter
public class FlightSeatLock {
    private final String lockBy;
    private final FlightSeat flightSeat;
    private final FlightSchedule flightSchedule;
    private final Date lockTime;
    private final Integer timeoutInSeconds;

    public FlightSeatLock(final String lockBy, FlightSeat flightSeat , FlightSchedule flightSchedule, Integer timeoutInSeconds) {
        this.lockBy = lockBy;
        this.flightSeat = flightSeat;
        this.flightSchedule = flightSchedule;
        this.lockTime = new Date();
        this.timeoutInSeconds = timeoutInSeconds;
    }

    public boolean isLockedExpired() {
        final Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutInSeconds);
        final Instant currentInstant = new Date().toInstant();
        return lockInstant.isBefore(currentInstant);
    }
}
