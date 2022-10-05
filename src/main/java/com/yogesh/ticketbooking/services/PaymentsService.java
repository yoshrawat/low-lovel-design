package com.yogesh.ticketbooking.services;

import com.yogesh.ticketbooking.exceptions.*;
import com.yogesh.ticketbooking.model.*;
import com.yogesh.ticketbooking.providers.*;
import lombok.*;

import java.util.*;

public class PaymentsService {
  Map<Booking, Integer> bookingFailures;
  private final Integer allowedRetries;
  private final SeatLockProvider seatLockProvider;

  public PaymentsService(@NonNull final Integer allowedRetries, SeatLockProvider seatLockProvider) {
    this.allowedRetries = allowedRetries;
    this.seatLockProvider = seatLockProvider;
    bookingFailures = new HashMap<>();
  }

  public void processPaymentFailed(@NonNull final Booking booking, @NonNull final String user) {
    if (!booking.getUser().equals(user)) {
      throw new BadRequestException();
    }
    if (!bookingFailures.containsKey(booking)) {
      bookingFailures.put(booking, 0);
    }
    final Integer currentFailuresCount = bookingFailures.get(booking);
    final Integer newFailuresCount = currentFailuresCount + 1;
    bookingFailures.put(booking, newFailuresCount);
    if (newFailuresCount > allowedRetries) {
      seatLockProvider.unlockSeats(booking.getShow(), booking.getSeatsBooked(), booking.getUser());
    }
  }
}
