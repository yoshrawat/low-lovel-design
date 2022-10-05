package com.yogesh.lockermanagement.strategy;

import com.yogesh.lockermanagement.model.*;
import lombok.*;

import java.util.*;

public class SlotAssignmentStrategyRandom implements ISlotAssignmentStrategy {

    private final IRandomGenerator randomGenerator;

    public SlotAssignmentStrategyRandom(@NonNull final IRandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    @Override
    public Slot pickSlot(@NonNull final List<Slot> slots) {
        if (slots.isEmpty()) {
            return null;
        }
        int slotNum = randomGenerator.getRandomNumber(slots.size());
        return slots.get(slotNum);
    }
}
