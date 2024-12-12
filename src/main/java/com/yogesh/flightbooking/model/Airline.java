package com.yogesh.flightbooking.model;

import lombok.*;

import java.util.*;

@Getter
public class Airline {
    private final String id;
    private final String name;
    private List<Flight> flightList;

    public Airline(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public void addFlight(final Flight flight) {
        this.flightList.add(flight);
    }
}
