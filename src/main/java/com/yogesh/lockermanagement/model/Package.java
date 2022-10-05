package com.yogesh.lockermanagement.model;

import lombok.*;

@Getter
public class Package implements LockerItem {
    private final String id;
    private final Size size;

    public Package(@NonNull final String id, @NonNull final Size size) {
        this.id = id;
        this.size = size;
    }
}
