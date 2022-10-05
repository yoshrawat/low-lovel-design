package com.yogesh.ticketbooking.api;

import com.yogesh.ticketbooking.model.*;
import com.yogesh.ticketbooking.services.*;
import lombok.*;

import java.util.*;
import java.util.stream.*;

@AllArgsConstructor
public class ShowController {
  private final SeatAvailabilityService seatAvailabilityService;
  private final ShowService showService;
  private final TheatreService theatreService;
  private final MovieService movieService;

  public String createShow(
      @NonNull final String movieId,
      @NonNull final String screenId,
      @NonNull final Date startTime,
      @NonNull final Integer durationInSeconds) {
    final Screen screen = theatreService.getScreen(screenId);
    final Movie movie = movieService.getMovie(movieId);
    return showService.createShow(movie, screen, startTime, durationInSeconds).getId();
  }

  public List<String> getAvailableSeats(@NonNull final String showId) {
    final Show show = showService.getShow(showId);
    final List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show);
    return availableSeats.stream().map(Seat::getId).collect(Collectors.toList());
  }
}
