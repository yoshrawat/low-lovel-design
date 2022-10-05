package com.yogesh.ticketbooking.api;

import com.yogesh.ticketbooking.model.*;
import com.yogesh.ticketbooking.services.*;
import lombok.*;

@AllArgsConstructor
public class TheatreController {
  private final TheatreService theatreService;

  public String createTheatre(@NonNull final String theatreName) {
    return theatreService.createTheatre(theatreName).getId();
  }

  public String createScreenInTheatre(
      @NonNull final String screenName, @NonNull final String theatreId) {
    final Theatre theatre = theatreService.getTheatre(theatreId);
    return theatreService.createScreenInTheatre(screenName, theatre).getId();
  }

  public String createSeatInScreen(
      @NonNull final Integer rowNo, @NonNull final Integer seatNo, @NonNull final String screenId) {
    final Screen screen = theatreService.getScreen(screenId);
    return theatreService.createSeatInScreen(rowNo, seatNo, screen).getId();
  }
}
