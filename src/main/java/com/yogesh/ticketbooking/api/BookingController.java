package com.yogesh.ticketbooking.api;

import com.yogesh.ticketbooking.model.*;
import com.yogesh.ticketbooking.services.*;
import lombok.*;

import java.util.*;
import java.util.stream.*;

@AllArgsConstructor
public class BookingController {
  private final ShowService showService;
  private final BookingService bookingService;
  private final TheatreService theatreService;

  public String createBooking(
      @NonNull final String userId,
      @NonNull final String showId,
      @NonNull final List<String> seatsIds) {
    final Show show = showService.getShow(showId);
    final List<Seat> seats =
        seatsIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
    return bookingService.createBooking(userId, show, seats).getId();
  }
}
