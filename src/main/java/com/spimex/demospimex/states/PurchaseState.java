package com.spimex.demospimex.states;

import com.spimex.demospimex.models.ClientAccount;
import com.spimex.demospimex.models.TransactionType;

public class PurchaseState implements TransactionState {
    @Override
    public double handleTransaction(ClientAccount clientAccount, TransactionType type, double amount) {
        // Логика для обработки покупок и начисления бонусов
        double bonus = calculateBonus(type, amount);
        clientAccount.setCash(clientAccount.getCash() - amount);
        clientAccount.seteMoney(clientAccount.geteMoney() + bonus);
        return bonus;
    }

    private double calculateBonus(TransactionType type, double amount) {
        double bonus = 0;
        if (type == TransactionType.SHOP) {
            bonus = amount * 0.10; // 10% бонус в магазине
        } else if (type == TransactionType.ONLINE) {
            bonus = amount * 0.17; // 17% бонус за онлайн покупки
        }
        if (amount > 300) {
            bonus += amount * 0.30; // Дополнительные 30% от суммы покупки
        }
        return bonus;
    }

}
