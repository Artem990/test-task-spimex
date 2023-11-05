package com.spimex.demospimex.service;

import com.spimex.demospimex.models.ClientAccount;
import com.spimex.demospimex.models.TransactionType;
import com.spimex.demospimex.repository.ClientAccountRepository;
import com.spimex.demospimex.states.PurchaseState;
import com.spimex.demospimex.states.ReturnState;
import com.spimex.demospimex.states.TransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    private ClientAccountRepository clientAccountRepository;

    @Autowired
    public BankService(ClientAccountRepository clientAccountRepository) {
        this.clientAccountRepository = clientAccountRepository;
    }
    private TransactionState currentState;

    public double makePurchase(TransactionType type, double amount, int clientAccountId) {
        ClientAccount clientAccount = clientAccountRepository.findById(clientAccountId);
        // Определяем состояние на основе суммы транзакции
        if (amount < 20) {
            currentState = new ReturnState();
        } else {
            currentState = new PurchaseState();
        }
        // Обработка транзакции с помощью текущего состояния
        return currentState.handleTransaction(clientAccount, type, amount);
    }

    public ClientAccount getClientAccount(int clientAccountId) {
        return clientAccountRepository.findById(clientAccountId);
    }

}