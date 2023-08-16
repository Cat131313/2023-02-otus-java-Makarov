package com.emakarov.hw06ATM;

public enum CurrencyDenomination {
    FIVE_THOUSAND(5000),
    ONE_THOUSAND(1000),
    FIVE_HUNDRED(500),
    ONE_HUNDRED(100),
    FIFTY(50);

    private final Integer denomination;

    CurrencyDenomination(Integer denomination) {
        this.denomination = denomination;
    }

    public Integer getDenomination() {
        return denomination;
    }
}

