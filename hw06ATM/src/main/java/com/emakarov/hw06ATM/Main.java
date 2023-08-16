package com.emakarov.hw06ATM;

import static com.emakarov.hw06ATM.CurrencyDenomination.FIVE_HUNDRED;
import static com.emakarov.hw06ATM.CurrencyDenomination.FIVE_THOUSAND;
import static com.emakarov.hw06ATM.CurrencyDenomination.ONE_HUNDRED;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.putMoney(FIVE_THOUSAND, 2);
        atm.putMoney(ONE_HUNDRED, 2);
        atm.putMoney(FIVE_HUNDRED, 1);
        System.out.printf(atm.getAccountBalance() + "\n");
        System.out.printf(atm.withdraw(5600) + "\n");
        System.out.printf(String.valueOf(atm.getAccountBalance()));
    }
}
