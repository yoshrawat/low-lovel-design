package com.yogesh.lockermanagement.service;

import com.yogesh.lockermanagement.model.*;
import com.yogesh.lockermanagement.repository.*;
import com.yogesh.lockermanagement.strategy.*;
import lombok.*;

public class OtpService {

    private final IOtpGenerator otpGenerator;
    private final SlotOtpRepositoryInMemory slotOtpRepository;

    public OtpService(IOtpGenerator otpGenerator, SlotOtpRepositoryInMemory slotOtpRepository) {
        this.otpGenerator = otpGenerator;
        this.slotOtpRepository = slotOtpRepository;
    }

    @NonNull
    public String generateOtp(@NonNull final Slot slot) {
        final String otp = otpGenerator.generateOtp();
        slotOtpRepository.addOtp(otp, slot.getSlotId());
        return otp;
    }

    public boolean validateOtp(@NonNull final Slot slot, @NonNull final String otp) {
        final String savedOtp = slotOtpRepository.getOtp(slot.getSlotId());
        return savedOtp != null && savedOtp.equals(otp);
    }
}
