package com.yogesh.ticketbooking.services;

import com.yogesh.ticketbooking.model.*;
import com.yogesh.ticketbooking.providers.*;
import lombok.*;

import java.util.*;

public class SeatAvailabilityService {
  private final BookingService bookingService;
  private final SeatLockProvider seatLockProvider;

  public SeatAvailabilityService(
      @NonNull final BookingService bookingService,
      @NonNull final SeatLockProvider seatLockProvider) {
    this.bookingService = bookingService;
    this.seatLockProvider = seatLockProvider;
  }

  public List<Seat> getAvailableSeats(@NonNull final Show show) {
    final List<Seat> allSeats = show.getScreen().getSeats();
    final List<Seat> unavailableSeats = getUnavailableSeats(show);

    final List<Seat> availableSeats = new ArrayList<>(allSeats);
    availableSeats.removeAll(unavailableSeats);
    return availableSeats;
  }

  private List<Seat> getUnavailableSeats(@NonNull final Show show) {
    final List<Seat> unavailableSeats = bookingService.getBookedSeats(show);
    unavailableSeats.addAll(seatLockProvider.getLockedSeats(show));
    return unavailableSeats;
  }
}
