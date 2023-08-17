package com.emakarov.hw05byte;

public class Main {
    public static void main(String[] args) {
        MyClassInterface test = Ioc.createClass(new MyClassImpl());
        test.calculation(10);
        test.calculation(3, 17);
        test.calculation(3, 17, "5");

        MyClassInterface test2 = Ioc.createClass(new MyClassImplTwo());
        test2.calculation(12);
        test2.calculation(3, 14);
        test2.calculation(4, 14, "5");
    }
}
