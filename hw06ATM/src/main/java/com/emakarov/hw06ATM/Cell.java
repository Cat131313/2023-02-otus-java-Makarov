package com.emakarov.hw06ATM;

public class Cell {

    int cellContentCount = 0;

    public Cell(int cellContentCount) {
        this.cellContentCount = cellContentCount;
    }

    public int getCellContentCount() {
        return cellContentCount;
    }

    public void add(Integer count) {
        cellContentCount += count;
    }

    public void withdraw(Integer count) {
        cellContentCount -= count;
    }
}
