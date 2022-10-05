package com.yogesh.flightbooking.model;

import lombok.*;

import java.util.*;

@Getter
public class Flight {
    private String id;
    private String flightNumber;
    private Airline airline;
    private List<Seat> seatList;
    private List<FlightSchedule> flightScheduleList;

    public Flight(final String id, final String flightNumber, final Airline airline) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.airline = airline;
    }

    public void addSeat(final List<Seat> seatList) {
        this.seatList.addAll(seatList);
    }
}
