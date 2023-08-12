package com.emakarov.hw03reflection.test;

public class TestLauncher {

    public static void main(String[] args) {
        String className = "com.emakarov.hw03reflection.test.TestClass";
        try {
            new TestRunner().run(className);
        } catch (Exception e) {
            System.out.printf(String.format("Exception: %s\nDetail: %s", e.getClass(), e.getMessage()));
        }
    }
}
