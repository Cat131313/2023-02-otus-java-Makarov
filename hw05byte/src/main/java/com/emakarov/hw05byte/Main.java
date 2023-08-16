package com.emakarov.hw05byte;

public class Main {
    public static void main(String[] args) {
        MyClassInterface test = Ioc.createMyClass();
        test.calculation(10);
        test.calculation(3, 17);
        test.calculation(3, 17, "5");
    }
}
