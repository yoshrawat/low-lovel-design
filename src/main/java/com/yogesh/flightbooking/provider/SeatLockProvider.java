package com.yogesh.flightbooking.provider;

import com.yogesh.flightbooking.model.*;

import java.util.*;

public interface SeatLockProvider {
    void lockSeats(FlightSchedule flightSchedule, List<FlightSeat> flightSeatList, String userId);

    void unLockSeats(FlightSchedule flightSchedule, List<FlightSeat> flightSeatList, String userId);

    List<FlightSeat> getLockedSeats(FlightSchedule flightSchedule);

    boolean validateLock(FlightSchedule flightSchedule, FlightSeat flightSeat, String userId);
}
