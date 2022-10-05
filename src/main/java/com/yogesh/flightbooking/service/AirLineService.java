package com.yogesh.flightbooking.service;

import com.yogesh.flightbooking.exception.*;
import com.yogesh.flightbooking.model.*;

import java.util.*;

public class AirLineService {
    Map<String, Airline> airLineServiceMap = new HashMap<>();

    public void addAirLine(final String name) {
        String id = UUID.randomUUID().toString();
        Airline airline = new Airline(id, name);
        airLineServiceMap.put(id, airline);
    }

    public void addFlight(final String id, final Flight flight) {
        if (!airLineServiceMap.containsKey(id)) {
            throw new InValidAirLineException("AirLine number is not Correctct");
        }
        Airline airline = airLineServiceMap.get(id);
        airline.addFlight(flight);
    }
}
