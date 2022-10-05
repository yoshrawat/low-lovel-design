package com.yogesh.flightbooking.model;

import lombok.*;

import java.util.*;

@Getter
public class Airport {
    private String id;
    private String name;
    private List<Flight> flightList;

    public Airport(final String id, final String name) {
        this.id = id;
        this.name = name;
    }
}
