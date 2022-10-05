package com.yogesh.cabbooking.controllers;

import com.yogesh.cabbooking.model.*;
import com.yogesh.cabbooking.services.*;

public class CabsController {
  private CabsService cabsService;
  private TripsService tripsService;

  public CabsController(CabsService cabsService, TripsService tripsService) {
    this.cabsService = cabsService;
    this.tripsService = tripsService;
  }

  public void regiserCab(final String cabId, final String driverName) {
    cabsService.createCab(new Cab(cabId, driverName));
  }

  public void updateCabLocation(final String cabId, final Double newX, final Double newY) {

    cabsService.updateCabLocation(cabId, new Location(newX, newY));
  }

  public void updateCabAvailability(final String cabId, final Boolean newAvailability) {
    cabsService.updateCabAvailability(cabId, newAvailability);
  }

  public void endTrip(final String cabId) {
    tripsService.endTrip(cabsService.getCab(cabId));
  }
}
