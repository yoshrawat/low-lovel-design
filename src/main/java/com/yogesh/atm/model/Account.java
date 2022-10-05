package com.yogesh.atm.model;

import com.yogesh.atm.enums.AccountType;

public class Account {
    private String accountNumber;
    private AccountType accountType;
    private double totalBalance;
    private double limit;

    public double getBalance() {
        return this.totalBalance;
    }
}
