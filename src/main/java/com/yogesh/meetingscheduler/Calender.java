package com.yogesh.meetingscheduler;

import lombok.*;

import java.util.*;

@Getter
public class Calender {
    private final List<Meeting> meetingList;
    private final MeetingRoom meetingRoom;
    private final EmailService emailService;

    public Calender(final MeetingRoom meetingRoom, final EmailService emailService) {
        this.meetingRoom = meetingRoom;
        this.emailService = emailService;
        meetingList = new ArrayList<>();
    }

    public boolean isAvailable(Date startDate, Date endDate) {
        for (Meeting meeting : meetingList) {
            if (meeting.getEndDate().compareTo(startDate) > 1 || meeting.getStarDate().compareTo(endDate) < 1)
                return false;
        }
        return true;
    }

    public Meeting scheduleNewMeeting(Date startDate, Date endDate) {
        Meeting meeting = new Meeting(meetingRoom, startDate, endDate);
        meetingList.add(meeting);

        emailService.sendEmail(meeting.getAttendeeList());
        return meeting;
    }
}
