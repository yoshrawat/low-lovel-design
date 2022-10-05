package com.yogesh.meetingscheduler;

import lombok.*;

import java.util.*;

@Getter
public class MeetingRoom {
    private final Calender calender;

    public MeetingRoom(final Calender calender) {
        this.calender = calender;
    }

    public boolean isAvailable(Date startDate, Date endDate) {
        return calender.isAvailable(startDate, endDate);
    }

    public Meeting bookMeeting(Date startDate, Date endDate) {
        return calender.scheduleNewMeeting(startDate, endDate);
    }
}
