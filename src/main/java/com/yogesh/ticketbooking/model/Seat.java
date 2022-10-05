package com.yogesh.ticketbooking.model;

import lombok.*;

@Getter
@AllArgsConstructor
public class Seat {
    private final String id;
    private final int rowNo;
    private final int seatNo;
}
