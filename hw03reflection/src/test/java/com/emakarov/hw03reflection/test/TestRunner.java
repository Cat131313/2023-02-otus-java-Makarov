package com.emakarov.hw03reflection.test;

import com.emakarov.hw03reflection.annotation.After;
import com.emakarov.hw03reflection.annotation.Before;
import com.emakarov.hw03reflection.annotation.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestRunner {

    public void run(String className) throws ClassNotFoundException {
        final Class<?> clazz = Class.forName(className);
        Method beforeMethod = null;
        List<Method> testMethods = new ArrayList<>();
        Method afterMethod = null;

        for (var method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Before.class)) {
                beforeMethod = method;
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            } else if (method.isAnnotationPresent(After.class)) {
                afterMethod = method;
            }
        }
        Integer successfulTestsCount = runTest(beforeMethod, afterMethod, testMethods, clazz);
        showResult(successfulTestsCount, testMethods);
    }

    private Integer runTest(Method before, Method after, List<Method> tests, Class<?> clazz) {
        Integer successfulTestsCount = 0;
        for (Method test : tests) {
            try {
                Object object = clazz.getConstructor().newInstance();
                if (Objects.nonNull(before)) {
                    before.invoke(object);
                }
                test.invoke(object);
                if (Objects.nonNull(after)) {
                    after.invoke(object);
                }
                successfulTestsCount++;
            } catch (Exception e) {
                System.out.printf("Exception during runtime, test: %s", test.getName());
            }
        }
        return successfulTestsCount;
    }

    private void showResult(Integer successfulTestsCount, List<Method> tests) {
        System.out.printf(String.format("\nSuccessful tests: %s\nError tests: %s\nTotal tests: %s",
                successfulTestsCount, tests.size() - successfulTestsCount, tests.size()));
    }
}
