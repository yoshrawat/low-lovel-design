package com.yogesh.meetingscheduler;

import com.yogesh.meetingscheduler.exception.*;
import lombok.*;

import java.util.*;

@Getter
public class Scheduler {
    private final List<MeetingRoom> meetingRoomList;
    private final List<Meeting> meetingList;

    public Scheduler(final List<MeetingRoom> meetingRoomList) {
        this.meetingRoomList = meetingRoomList;
        meetingList = new ArrayList<>();
    }

    public Meeting scheduleMeeting(final Date startDate, final Date endDate) {
        for (MeetingRoom meetingRoom : meetingRoomList) {
            if (meetingRoom.isAvailable(startDate, endDate)) {
                Meeting meeting = meetingRoom.bookMeeting(startDate, endDate);
                meetingList.add(meeting);
                return meeting;
            }
        }
        throw new NoMeetingRoomsAvailableException();
    }

    public void addAttendees(final Meeting meeting, final List<Attendee> attendeeList) {
        meeting.addAttendees(attendeeList);
    }

    public List<Meeting> getAllMeeting() {
        return meetingList;
    }

}
