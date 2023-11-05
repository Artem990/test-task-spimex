package com.spimex.demospimex.models;

public class ClientAccount {

    public ClientAccount(double cash, double eMoney) {
        this.cash = cash;
        this.eMoney = eMoney;
    }

    private double cash;
    private double eMoney;
    // getters and setters


    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double geteMoney() {
        return eMoney;
    }

    public void seteMoney(double eMoney) {
        this.eMoney = eMoney;
    }
}