package com.yogesh.meetingscheduler;

import lombok.*;

import java.util.*;

@Getter
public class Meeting {
    private final MeetingRoom meetingRoom;
    private final Date starDate;
    private final Date endDate;
    private List<Attendee> attendeeList;

    public Meeting(final MeetingRoom meetingRoom, final Date starDate, final Date endDate) {
        this.meetingRoom = meetingRoom;
        this.starDate = starDate;
        this.endDate = endDate;
    }

    public void addAttendees(final List<Attendee> attendeeList) {
        this.addAttendees(attendeeList);
    }
}
