package com.yogesh.hotelbooking.model;

import com.yogesh.hotelbooking.exception.*;
import lombok.*;

import java.util.*;

@Getter
public class Booking {
    private String id;
    private String userId;
    private Hotel hotel;
    private List<Room> roomList;
    private Date startDate;
    private Date endDate;
    private BookingStatus bookingStatus;

    public Booking(final String id, final String userId, final Hotel hotel, final List<Room> roomList, final Date startDate, final Date endDate) {
        this.id = id;
        this.userId = userId;
        this.hotel = hotel;
        this.roomList = roomList;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public void confirmBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new InvalidStateException("Booking Status is Not Valid");
        }
        this.bookingStatus = BookingStatus.CONFIRMED;
    }
    public void expireBooking() {
        if (this.bookingStatus != BookingStatus.CREATED) {
            throw new InvalidStateException("Booking Status is Not Valid");
        }
        this.bookingStatus = BookingStatus.EXPIRED;
    }
}
