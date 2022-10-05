package com.yogesh.lockermanagement.repository;

import lombok.*;

import java.util.*;

public class SlotOtpRepositoryInMemory implements ISlotOtpRepository {

    // Keeping it separate and not in slot object itself as it can be a separate service to handle otps.
    // TODO: Create separate OTP model class may be when use cases increase like handling expiry of otps.
    private final Map<String, String> slotIdToOtpMap;

    public SlotOtpRepositoryInMemory() {
        this.slotIdToOtpMap = new HashMap<>();
    }

    @Override
    public void addOtp(@NonNull final String otp, @NonNull final String slotId) {
        slotIdToOtpMap.put(slotId, otp);
    }

    @Override
    public String getOtp(@NonNull final String slotId) {
        return slotIdToOtpMap.get(slotId);
    }
}
