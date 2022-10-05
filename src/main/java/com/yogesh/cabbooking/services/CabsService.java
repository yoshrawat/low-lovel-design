package com.yogesh.cabbooking.services;

import com.yogesh.cabbooking.exceptions.*;
import com.yogesh.cabbooking.model.*;
import lombok.*;

import java.util.*;

public class CabsService {

  Map<String, Cab> cabs = new HashMap<>();

  public void createCab(@NonNull final Cab newCab) {
    if (cabs.containsKey(newCab.getId())) {
      throw new CabAlreadyExistsException();
    }

    cabs.put(newCab.getId(), newCab);
  }

  public Cab getCab(@NonNull final String cabId) {
    if (!cabs.containsKey(cabId)) {
      throw new CabNotFoundException();
    }
    return cabs.get(cabId);
  }

  public void updateCabLocation(@NonNull final String cabId, @NonNull final Location newLocation) {
    if (!cabs.containsKey(cabId)) {
      throw new CabNotFoundException();
    }
    cabs.get(cabId).setCurrentLocation(newLocation);
  }

  public void updateCabAvailability(
      @NonNull final String cabId, @NonNull final Boolean newAvailability) {
    if (!cabs.containsKey(cabId)) {
      throw new CabNotFoundException();
    }
    cabs.get(cabId).setIsAvailable(newAvailability);
  }

  public List<Cab> getCabs(@NonNull final Location fromPoint, @NonNull final Double distance) {
    List<Cab> result = new ArrayList<>();
    for (Cab cab : cabs.values()) {
      // TODO: Use epsilon comparison because of double
      if (cab.getIsAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance) {
        result.add(cab);
      }
    }
    return result;
  }
}
