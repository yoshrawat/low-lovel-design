package com.yogesh.flightbooking.model;

import com.yogesh.flightbooking.exception.*;
import lombok.*;

import java.util.*;

@Getter
public class Booking {
    private String id;
    private String userId;
    private FlightSchedule flightSchedule;
    private List<FlightSeat> flightSeatList;
    private BookingStatus bookingStatus;

    public Booking(final String id, String userId, final FlightSchedule flightSchedule, List<FlightSeat> flightSeatList) {
        this.id = id;
        this.userId = userId;
        this.flightSchedule = flightSchedule;
        this.flightSeatList = flightSeatList;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public void confirmBooking() {
        if (bookingStatus != BookingStatus.CREATED) {
            throw new InValidStateException();
        }
        bookingStatus = BookingStatus.CONFIRMED;
    }

    public void expireBooking() {
        if (bookingStatus != BookingStatus.CREATED) {
            throw new InValidStateException();
        }
        bookingStatus = BookingStatus.EXPIRED;
    }

    public boolean isConfirmed() {
        return bookingStatus == BookingStatus.CONFIRMED;
    }
}
