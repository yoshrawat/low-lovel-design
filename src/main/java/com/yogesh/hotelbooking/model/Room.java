package com.yogesh.hotelbooking.model;


import lombok.*;

@Getter
public class Room {
    private String roomId;
    private String roomNumber;
    private RoomType roomType;
    @Setter
    private boolean isAvailable;
    private RoomStatus roomStatus;

    private Hotel hotel;

    public Room(final String roomId, String roomNumber, final RoomType roomType, final Hotel hotel) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.hotel = hotel;
        this.roomStatus = RoomStatus.AVAILABLE;
    }
}
