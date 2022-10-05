package com.yogesh.flightbooking.model;

import lombok.*;

@Getter
public class FlightSeat extends Seat {
    private int price;
    private SeatClass seatClass;

    public FlightSeat(final String id, final int rowNumber, final int seatNumber, final int price, final SeatClass seatClass) {
        super(id, rowNumber, seatNumber);
        this.price = price;
        this.seatClass = seatClass;
    }

    public void updatePrice(final int price) {
        this.price = price;
    }
}
