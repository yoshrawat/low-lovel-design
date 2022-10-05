package com.yogesh.lockermanagement.strategy;

import lombok.*;

public interface IOtpGenerator {

    @NonNull
    String generateOtp();
}
