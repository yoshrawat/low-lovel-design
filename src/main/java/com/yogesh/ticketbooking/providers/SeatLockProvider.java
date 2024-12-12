package com.yogesh.ticketbooking.providers;

import com.yogesh.ticketbooking.model.*;
import lombok.*;

import java.util.*;

public interface SeatLockProvider {
  void lockSeats(Show show, List<Seat> seat, String user);

  void unlockSeats(Show show, List<Seat> seat, String user);

  boolean validateLock(Show show, Seat seat, String user);

  List<Seat> getLockedSeats(Show show);
}
