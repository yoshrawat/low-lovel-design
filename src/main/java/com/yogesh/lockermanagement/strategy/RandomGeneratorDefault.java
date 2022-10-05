package com.yogesh.lockermanagement.strategy;

import lombok.*;

public class RandomGeneratorDefault implements IRandomGenerator {

    @NonNull
    @Override
    public Integer getRandomNumber(Integer lessThanThis) {
        return (int) (Math.random() * lessThanThis);
    }
}
