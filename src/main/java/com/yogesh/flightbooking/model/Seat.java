package com.yogesh.flightbooking.model;

import lombok.*;

@Getter
public class Seat {
    private String id;
    private int rowNumber;
    private int seatNumber;

    public Seat(String id, int rowNumber, int seatNumber) {
        this.id = id;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }
}
