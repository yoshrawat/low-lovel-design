package com.yogesh.lockermanagement.model;

import lombok.*;

@Getter
public class Contact {

    String phone;
    String email;

    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }
}
