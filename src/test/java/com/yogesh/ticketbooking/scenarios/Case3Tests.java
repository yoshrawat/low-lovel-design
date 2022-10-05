package com.yogesh.ticketbooking.scenarios;

import com.google.common.collect.*;
import com.yogesh.ticketbooking.exceptions.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class Case3Tests extends BaseTest {

  @BeforeEach
  void setUp() {
    setupControllers(10, 0);
  }

  @Test
  void testCase3() {
    String user1 = "User1";
    String user2 = "User2";

    final String movie = movieController.createMovie("Movie 1");
    final String screen = setupScreen();
    final List<String> screen1SeatIds = createSeats(theatreController, screen, 2, 10);

    final String show = showController.createShow(movie, screen, new Date(), 2 * 60 * 60);

    List<String> u1AvailableSeats = showController.getAvailableSeats(show);

    // Validate that seats u1 received has all screen seats
    validateSeatsList(u1AvailableSeats, screen1SeatIds, ImmutableList.of());

    ImmutableList<String> u1SelectedSeats =
        ImmutableList.of(
            screen1SeatIds.get(0),
            screen1SeatIds.get(2),
            screen1SeatIds.get(5),
            screen1SeatIds.get(10));

    ImmutableList<String> u2SelectedSeats =
        ImmutableList.of(
            screen1SeatIds.get(0),
            screen1SeatIds.get(1),
            screen1SeatIds.get(2),
            screen1SeatIds.get(3));

    final String u1BookingId = bookingController.createBooking(user1, show, u1SelectedSeats);

    Assertions.assertThrows(
        SeatTemporaryUnavailableException.class,
        () -> {
          final String u2BookingId = bookingController.createBooking(user2, show, u2SelectedSeats);
        });

    paymentsController.paymentSuccess(u1BookingId, user1);

    Assertions.assertThrows(
        SeatPermanentlyUnavailableException.class,
        () -> {
          final String u2BookingId = bookingController.createBooking(user2, show, u2SelectedSeats);
        });
  }
}
