package com.yogesh.hotelbooking.model;

import lombok.*;

import java.util.*;

@Getter
public class Hotel {
    private String id;
    private String name;
    private List<Room> roomList;

    public Hotel(final String id, final String name) {
        this.id = id;
        this.name = name;
        roomList = new ArrayList<>();
    }

    public void addRoom(final Room room) {
        roomList.add(room);
    }
}
