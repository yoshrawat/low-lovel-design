package com.yogesh.lockermanagement.strategy;

import com.yogesh.lockermanagement.model.*;
import lombok.*;

import java.util.*;
import java.util.stream.*;

public class SlotFilteringStrategySizeBased implements ISlotFilteringStrategy {

    @NonNull
    @Override
    public List<Slot> filterSlots(@NonNull final List<Slot> slots, @NonNull final LockerItem lockerItem) {
        return slots.stream()
                .filter(slot -> slot.getSize().canAccommodate(lockerItem.getSize()))
                .collect(Collectors.toList());
    }
}
