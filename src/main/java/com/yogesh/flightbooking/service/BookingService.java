package com.yogesh.flightbooking.service;

import com.yogesh.flightbooking.exception.*;
import com.yogesh.flightbooking.model.*;
import com.yogesh.flightbooking.provider.*;

import java.util.*;
import java.util.stream.*;

public class BookingService {
    private final Map<String, Booking> bookingMap;
    private final SeatLockProvider seatLockProvider;

    public BookingService(SeatLockProvider seatLockProvider) {
        this.bookingMap = new HashMap<>();
        this.seatLockProvider = seatLockProvider;
    }

    public Booking createBooking(final String userId, final FlightSchedule flightSchedule, List<FlightSeat> flightSeatList) {
        if (isAnySeatAlreadyBooked(flightSchedule, flightSeatList)) {
            throw new SeatPermanentlyUnavailableException();
        }
        seatLockProvider.lockSeats(flightSchedule, flightSeatList, userId);
        String id = UUID.randomUUID().toString();
        Booking booking = new Booking(id, userId, flightSchedule, flightSeatList);
        bookingMap.put(id, booking);
        return booking;
    }

    private boolean isAnySeatAlreadyBooked(FlightSchedule flightSchedule, List<FlightSeat> flightSeatList) {
        final List<FlightSeat> bookedSeatList = getBookedSeats(flightSchedule);
        for (FlightSeat flightSeat : flightSeatList) {
            if (bookedSeatList.contains(flightSeat))
                return true;
        }
        return false;
    }

    public List<Booking> getAllBooking(final FlightSchedule flightSchedule) {
        List<Booking> response = new ArrayList<>();
        for (Booking booking : bookingMap.values()) {
            if (booking.getFlightSchedule().equals(flightSchedule))
                response.add(booking);
        }
        return response;
    }

    public List<FlightSeat> getBookedSeats(final FlightSchedule flightSchedule) {
        return getAllBooking(flightSchedule).stream().filter(Booking::isConfirmed).map(Booking::getFlightSeatList)
                .flatMap(Collection::stream).collect(Collectors.toList());
    }

    public void confirmBooking(final Booking booking, String userId) {
        if (!booking.getUserId().equals(userId)) {
            throw new BadRequestException();
        }
        for(FlightSeat flightSeat : booking.getFlightSeatList()) {
            if(!seatLockProvider.validateLock(booking.getFlightSchedule(), flightSeat, userId)) {
                throw new BadRequestException();
            }
        }
        booking.confirmBooking();
    }
}
