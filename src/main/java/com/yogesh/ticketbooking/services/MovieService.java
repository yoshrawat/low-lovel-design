package com.yogesh.ticketbooking.services;

import com.yogesh.ticketbooking.exceptions.*;
import com.yogesh.ticketbooking.model.*;
import lombok.*;

import java.util.*;

public class MovieService {
  private final Map<String, Movie> movies;

  public MovieService() {
    this.movies = new HashMap<>();
  }

  public Movie getMovie(@NonNull final String movieId) {
    if (!movies.containsKey(movieId)) {
      throw new NotFoundException();
    }
    return movies.get(movieId);
  }

  public Movie createMovie(@NonNull final String movieName) {
    String movieId = UUID.randomUUID().toString();
    Movie movie = new Movie(movieId, movieName);
    movies.put(movieId, movie);
    return movie;
  }
}
