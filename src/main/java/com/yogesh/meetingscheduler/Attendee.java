package com.yogesh.meetingscheduler;

import lombok.*;

@Getter
public class Attendee {
    private final String name;
    @Setter
    private String email;

    public Attendee(final String name) {
        this.name = name;
    }
}
