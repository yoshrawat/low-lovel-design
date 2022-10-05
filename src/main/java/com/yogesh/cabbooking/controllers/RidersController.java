package com.yogesh.cabbooking.controllers;

import com.yogesh.cabbooking.model.*;
import com.yogesh.cabbooking.services.*;

import java.util.*;

public class RidersController {
  private RidersService ridersService;
  private TripsService tripsService;

  public RidersController(RidersService ridersService, TripsService tripsService) {
    this.ridersService = ridersService;
    this.tripsService = tripsService;
  }

  public void registerRider(final String riderId, final String riderName) {
    ridersService.createRider(new Rider(riderId, riderName));
  }

  public void book(
      final String riderId,
      final Double sourceX,
      final Double sourceY,
      final Double destX,
      final Double destY) {

    tripsService.createTrip(
        ridersService.getRider(riderId),
        new Location(sourceX, sourceY),
        new Location(destX, destY));
  }

  public List<Trip> fetchHistory(final String riderId) {
    return tripsService.tripHistory(ridersService.getRider(riderId));
  }
}
