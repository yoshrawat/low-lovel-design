package com.yogesh.cabbooking.services;

import com.yogesh.cabbooking.exceptions.*;
import com.yogesh.cabbooking.model.*;
import lombok.*;

import java.util.*;

public class RidersService {
  Map<String, Rider> riders = new HashMap<>();

  public void createRider(@NonNull final Rider newRider) {
    if (riders.containsKey(newRider.getId())) {
      throw new RiderAlreadyExistsException();
    }

    riders.put(newRider.getId(), newRider);
  }

  public Rider getRider(@NonNull final String riderId) {
    if (!riders.containsKey(riderId)) {
      throw new RiderNotFoundException();
    }
    return riders.get(riderId);
  }
}
