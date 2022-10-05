package com.yogesh.lockermanagement.repository;

import com.yogesh.lockermanagement.model.*;
import lombok.*;

import java.util.*;

public interface ILockerRepository {

    @NonNull
    Locker createLocker(@NonNull String id);

    @NonNull
    List<Slot> getAllAvailableSlots();
}
