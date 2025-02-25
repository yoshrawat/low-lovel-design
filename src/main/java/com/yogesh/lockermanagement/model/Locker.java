package com.yogesh.lockermanagement.model;

import lombok.*;

import java.util.*;

@Getter
public class Locker {

    private final String id;
    private final List<Slot> slots;

    public Locker(String id) {
        this.id = id;
        this.slots = new ArrayList<>();
    }

    public void addSlot(@NonNull final Slot newSlot) {
        this.slots.add(newSlot);
    }

    @NonNull
    public List<Slot> getAvailableSlots() {
        final List<Slot> result = new ArrayList<>();
        for (Slot slot : this.slots) {
            if (slot.isAvailable()) {
                result.add(slot);
            }
        }
        return result;
    }
}
