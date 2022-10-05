package com.yogesh.flightbooking.provider;

import com.google.common.collect.*;
import com.yogesh.flightbooking.exception.*;
import com.yogesh.flightbooking.model.*;

import java.util.*;

public class InMemorySeatLockProviderImpl implements SeatLockProvider {

    private final Integer lockTimeout;
    private final Map<FlightSchedule, Map<FlightSeat, FlightSeatLock>> locks;

    public InMemorySeatLockProviderImpl(final Integer lockTimeout) {
        this.lockTimeout = lockTimeout;
        locks = new HashMap<>();
    }

    @Override
    public synchronized void lockSeats(FlightSchedule flightSchedule, List<FlightSeat> flightSeatList, String userId) {
        for (FlightSeat flightSeat : flightSeatList) {
            if (isSeatLocked(flightSchedule, flightSeat)) {
                throw new SeatTemporaryUnavailableException();
            }
        }
        for (FlightSeat flightSeat : flightSeatList) {
            lockSeat(flightSchedule, flightSeat, userId, lockTimeout);
        }
    }

    private void lockSeat(FlightSchedule flightSchedule, FlightSeat flightSeat, String userId, Integer lockTimeout) {
        if (!locks.containsKey(flightSchedule)) {
            locks.put(flightSchedule, new HashMap<>());
        }
        final FlightSeatLock flightSeatLock = new FlightSeatLock(userId, flightSeat, flightSchedule, lockTimeout);
        locks.get(flightSchedule).put(flightSeat, flightSeatLock);
    }

    private boolean isSeatLocked(FlightSchedule flightSchedule, FlightSeat flightSeat) {
        return locks.containsKey(flightSchedule) && locks.get(flightSchedule).containsKey(flightSeat) && !locks.get(flightSchedule)
                .get(flightSeat).isLockedExpired();
    }


    @Override
    public void unLockSeats(FlightSchedule flightSchedule, List<FlightSeat> flightSeatList, String userId) {
        for (FlightSeat flightSeat : flightSeatList) {
            if (validateLock(flightSchedule, flightSeat, userId)) {
                unLockSeat(flightSchedule, flightSeat);
            }
        }
    }

    private void unLockSeat(FlightSchedule flightSchedule, FlightSeat flightSeat) {
        if (!locks.containsKey(flightSchedule))
            return;
        locks.get(flightSchedule).remove(flightSeat);
    }

    @Override
    public List<FlightSeat> getLockedSeats(FlightSchedule flightSchedule) {
        if (!locks.containsKey(flightSchedule)) {
            return ImmutableList.of();
        }
        final List<FlightSeat> lockedSeats = new ArrayList<>();

        for (FlightSeat flightSeat : locks.get(flightSchedule).keySet()) {
            if (isSeatLocked(flightSchedule, flightSeat)) {
                lockedSeats.add(flightSeat);
            }
        }
        return lockedSeats;
    }

    @Override
    public boolean validateLock(FlightSchedule flightSchedule, FlightSeat flightSeat, String userId) {
        return isSeatLocked(flightSchedule, flightSeat) && locks.get(flightSchedule).get(flightSeat).getLockBy().equals(userId);
    }
}
