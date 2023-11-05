package com.spimex.demospimex.controller;


import com.spimex.demospimex.models.ClientAccount;
import com.spimex.demospimex.models.TransactionType;
import com.spimex.demospimex.service.BankService;
import com.spimex.demospimex.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    // TODO уточнить на счет GET для запросов изменения
    @PostMapping("/payment/{type}/{amount}")
    public ResponseEntity<?> makePayment(@PathVariable("type") String type, @PathVariable("amount") double amount) {
        // предположим, что id клиента мы получили из запроса
        int clientAccountId = 1;
        TransactionType transactionType = TransactionType.valueOf(type.toUpperCase());
        double bonus = bankService.makePurchase(transactionType, amount, clientAccountId);
        return ResponseEntity.ok("Bonus accrued: " + Util.doubleToDecimal(bonus));
    }

    @GetMapping("/bankAccountOfEMoney")
    public ResponseEntity<?> getBankAccountOfEMoney() {
        // предположим, что id клиента мы получили из запроса
        int clientAccountId = 1;
        return ResponseEntity.ok(Util.doubleToDecimal(bankService.getClientAccount(clientAccountId).geteMoney()));
    }

    @GetMapping("/money")
    public ResponseEntity<?> getMoney() {
        // предположим, что id клиента мы получили из запроса
        int clientAccountId = 1;
        ClientAccount account = bankService.getClientAccount(clientAccountId);
        return ResponseEntity.ok("Cash: " + Util.doubleToDecimal(account.getCash())
                + ", E-money: " + Util.doubleToDecimal(account.geteMoney()));
    }
}