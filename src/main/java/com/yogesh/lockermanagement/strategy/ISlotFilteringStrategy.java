package com.yogesh.lockermanagement.strategy;

import com.yogesh.lockermanagement.model.*;
import lombok.*;

import java.util.*;

public interface ISlotFilteringStrategy {

    @NonNull
    List<Slot> filterSlots(@NonNull List<Slot> slots, @NonNull LockerItem lockerItem);
}
