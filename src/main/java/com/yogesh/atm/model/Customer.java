package com.yogesh.atm.model;

import com.yogesh.atm.enums.CustomerStatus;

public class Customer {
  private String firstName;
  private String lastName;
  private Address address;
  private CustomerStatus customerStatus;
  private Card card;
  private Account account;

  private boolean makeTransaction() {
    return true;
  }

  private Address getBillingAddress() {
    return this.address;
  }
}
