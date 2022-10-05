package com.yogesh.flightbooking.model;

import lombok.*;

import java.util.*;

@Getter
public class FlightSchedule {
    private String id;
    private Flight flight;
    private Airport startAirport;
    private Airport destAirport;
    private Date startTime;
    private int duration;
    private FlightStatus flightStatus;
    private List<FlightSeat> flightSeatList;

    public FlightSchedule(final String id, final Flight flight, final Airport startAirport, final Airport destAirport, final Date startTime, final int duration) {
        this.id = id;
        this.flight = flight;
        this.startAirport = startAirport;
        this.destAirport = destAirport;
        this.startTime = startTime;
        this.duration = duration;
        this.flightStatus = FlightStatus.ONTIME;
    }

    public void addFlightSeat(final FlightSeat flightSeat) {
        this.flightSeatList.add(flightSeat);
    }
}
