package com.emakarov.hw06ATM;

public interface ATMInterface {
    void putMoney(CurrencyDenomination currencyDenomination, int count);
    boolean withdraw(int sum);
    int getAccountBalance();
}
