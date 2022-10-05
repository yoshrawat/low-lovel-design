package com.yogesh.cabbooking.strategies;

import com.yogesh.cabbooking.model.*;

import java.util.*;

public interface CabMatchingStrategy {
  Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint);
}
