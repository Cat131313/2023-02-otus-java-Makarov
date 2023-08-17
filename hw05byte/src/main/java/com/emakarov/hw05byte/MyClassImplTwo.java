package com.emakarov.hw05byte;

public class MyClassImplTwo implements MyClassInterface {

    @Override
    @Log
    public void calculation(int param1) {
        System.out.printf("Some code with 1 param \n");
    }

    @Override
    @Log
    public void calculation(int param1, int param2) {
        System.out.printf("Some code with 2 param \n");
    }

    @Override
    @Log
    public void calculation(int param1, int param2, String param3) {
        System.out.printf("Some code with 3 param \n");
    }
}