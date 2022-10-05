package com.yogesh.hotelbooking.service;

import com.yogesh.hotelbooking.model.*;

import java.util.*;

public class HotelService {
    private Map<String, Hotel> hotelMap;

    public Hotel addHotel(final String name) {
        String id = UUID.randomUUID().toString();
        Hotel hotel = new Hotel(id, name);
        hotelMap.put(id, hotel);
        return hotel;
    }

    public void addRoom(final String hotelId, final RoomType roomType, final String roomNumber) {
        Hotel hotel = hotelMap.get(hotelId);
        String id = UUID.randomUUID().toString();
        Room room = new Room(id, roomNumber, roomType, hotel);
        hotel.addRoom(room);
    }
}
