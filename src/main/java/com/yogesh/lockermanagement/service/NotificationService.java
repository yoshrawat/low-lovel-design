package com.yogesh.lockermanagement.service;

import com.yogesh.lockermanagement.model.*;
import lombok.*;

public class NotificationService {

    public void notifyUser(@NonNull final LockerUser user, @NonNull final String otp, @NonNull final Slot slot) {
        // Use third party api to send actual notification like sms, email etc.
        System.out.println("Sending notification of otp: " + otp + " to: " + user + " for slot: " + slot);
    }
}
