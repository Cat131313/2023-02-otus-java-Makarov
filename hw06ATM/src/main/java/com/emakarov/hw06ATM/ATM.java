package com.emakarov.hw06ATM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ATM implements ATMInterface{

    Map<CurrencyDenomination, Cell> cellMap = new HashMap<>();

    @Override
    public int getAccountBalance() {
        int balance = 0;
        for (Map.Entry<CurrencyDenomination, Cell> entry : cellMap.entrySet()) {
            balance += entry.getKey().getDenomination() * entry.getValue().getCellContentCount();
        }
        return balance;
    }

    @Override
    public void putMoney(CurrencyDenomination currencyDenomination, int count) {
        Cell cell = cellMap.get(currencyDenomination);
        if (cell == null) {
            cellMap.put(currencyDenomination, new Cell(count));
        } else {
            cell.add(count);
        }
    }

    @Override
    public boolean withdraw(int amount) {
        List<CurrencyDenomination> currencyDenominationList = new LinkedList<>(cellMap.keySet());
        currencyDenominationList.sort(Comparator.comparing(CurrencyDenomination::getDenomination)
                .reversed());

        List<CurrencyDenomination> denominationsIfMayWithdraw = new ArrayList<>();
        int sum = 0;

        for (CurrencyDenomination currencyDenomination : currencyDenominationList) {
            Cell cell = cellMap.get(currencyDenomination);
            for (int i = 0; i < cell.getCellContentCount(); i++) {
                if (sum + currencyDenomination.getDenomination() <= amount) {
                    sum += currencyDenomination.getDenomination();
                    denominationsIfMayWithdraw.add(currencyDenomination);
                }
                if (sum == amount) {
                    takeMoneyATM(denominationsIfMayWithdraw);
                    return true;
                }
            }
        }
        return false;
    }

    public void takeMoneyATM(List<CurrencyDenomination> answer) {
        answer.forEach(currencyDenomination -> {
            Cell cell = cellMap.get(currencyDenomination);
            cell.withdraw(1);
        });
    }
}
