package com.yogesh.lockermanagement.model;

import lombok.*;

@Getter
public abstract class LockerUser {
    private final Contact contact;

    public LockerUser(Contact contact) {
        this.contact = contact;
    }
}
