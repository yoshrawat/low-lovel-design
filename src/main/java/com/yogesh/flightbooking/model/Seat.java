package com.yogesh.flightbooking.model;

import lombok.*;

@Getter
public class Seat {
    private final String id;
    private final int rowNumber;
    private final int seatNumber;

    public Seat(String id, int rowNumber, int seatNumber) {
        this.id = id;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }
}
