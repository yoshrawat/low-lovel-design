package com.yogesh.flightbooking.service;

import com.yogesh.flightbooking.model.*;

import java.util.*;

public class AirPortService {
    Map<String, Airport> airportMap = new HashMap<>();

    public void addAirPort(final String name) {
        String id = UUID.randomUUID().toString();
        Airport airport = new Airport(id, name);
        airportMap.put(id, airport);
    }
}
