package com.yogesh.hotelbooking.service;

import com.yogesh.hotelbooking.model.*;

import java.util.*;

public class BookingService {
    Map<String, Booking> bookingMap = new HashMap<>();

    public Booking createBooking(final String userId, final Hotel hotel, final List<Room> roomList, final Date startDate, final Date endDate) {
        String id = UUID.randomUUID().toString();
        Booking booking = new Booking(id, userId, hotel, roomList, startDate, endDate);
        bookingMap.put(id, booking);
        return booking;
    }

    public void confirmBooking(final Booking booking) {
        booking.confirmBooking();
    }
}
