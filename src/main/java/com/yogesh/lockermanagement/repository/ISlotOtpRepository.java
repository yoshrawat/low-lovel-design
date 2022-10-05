package com.yogesh.lockermanagement.repository;

import lombok.*;

public interface ISlotOtpRepository {
    void addOtp(@NonNull String otp, @NonNull String slotId);

    String getOtp(@NonNull String slotId);
}
