package com.yogesh.atm.model;

import com.yogesh.atm.enums.TransactionStatus;
import com.yogesh.atm.enums.TransactionType;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;
    private Date createdDate;
}
