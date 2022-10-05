package com.yogesh.lockermanagement.strategy;

import com.yogesh.lockermanagement.model.*;
import lombok.*;

import java.util.*;

public interface ISlotAssignmentStrategy {

    Slot pickSlot(@NonNull List<Slot> slots);
}
