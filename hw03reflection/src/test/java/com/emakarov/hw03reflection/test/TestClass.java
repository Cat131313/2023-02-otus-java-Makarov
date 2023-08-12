package com.emakarov.hw03reflection.test;

import com.emakarov.hw03reflection.TestMethod;
import com.emakarov.hw03reflection.annotation.After;
import com.emakarov.hw03reflection.annotation.Before;
import com.emakarov.hw03reflection.annotation.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestClass {

    @Before
    void before() {
        System.out.println("Before method");
    }

    @Test
    public void add() {
        assertThat(TestMethod.add(1, 1)).isEqualTo(2);
    }

    @Test
    public void divideGetAssertException() throws Exception {
        assertThat(TestMethod.divide(10, 2)).isEqualTo(210101);
    }

    @Test
    public void multiply() {
        assertThat(TestMethod.multiply(10, 2)).isEqualTo(20);
    }

    @Test
    public void subtract() {
        assertThat(TestMethod.subtract(10, 2)).isEqualTo(8);
    }

    @After
    void after() {
        System.out.println("After method");
    }
}
