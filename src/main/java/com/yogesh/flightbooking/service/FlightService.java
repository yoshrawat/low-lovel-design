package com.yogesh.flightbooking.service;

import com.yogesh.flightbooking.model.*;

import java.util.*;

public class FlightService {
    Map<String, Flight> flightMap = new HashMap<>();

    public Flight createFlight(final String flightNumber, final Airline airline) {
        String id = UUID.randomUUID().toString();
        Flight flight = new Flight(id, flightNumber, airline);
        flightMap.put(id, flight);
        return flight;
    }
}
