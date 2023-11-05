package com.spimex.demospimex.states;

import com.spimex.demospimex.models.ClientAccount;
import com.spimex.demospimex.models.TransactionType;

public interface TransactionState {
    double handleTransaction(ClientAccount clientAccount, TransactionType type, double amount);
}
