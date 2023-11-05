package com.spimex.demospimex.states;

import com.spimex.demospimex.models.ClientAccount;
import com.spimex.demospimex.models.TransactionType;

public class ReturnState implements TransactionState{

    @Override
    public double handleTransaction(ClientAccount clientAccount, TransactionType type, double amount) {
        // Логика для обработки возвратов
        double commission = amount * 0.10;
        clientAccount.setCash(clientAccount.getCash() - (amount + commission));
        return -commission; // Возвращаем отрицательный бонус (комиссию)
    }
}
