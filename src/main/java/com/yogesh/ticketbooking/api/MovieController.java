package com.yogesh.ticketbooking.api;

import com.yogesh.ticketbooking.services.*;
import lombok.*;

@AllArgsConstructor
public class MovieController {
  private final MovieService movieService;

  public String createMovie(@NonNull final String movieName) {
    return movieService.createMovie(movieName).getId();
  }
}
