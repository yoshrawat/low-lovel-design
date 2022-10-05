package com.yogesh.lockermanagement.strategy;

import lombok.*;

public interface IRandomGenerator {

    @NonNull
    Integer getRandomNumber(@NonNull Integer lessThanThis);
}
