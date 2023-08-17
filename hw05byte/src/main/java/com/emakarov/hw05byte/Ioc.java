package com.emakarov.hw05byte;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ioc {

    private Ioc() {
    }

    static MyClassInterface createClass(MyClassInterface myClass) {
        InvocationHandler handler = new DemoInvocationHandler(myClass);
        return (MyClassInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{MyClassInterface.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final List<String> methodsWithAnnotationLog = new ArrayList<>();
        private final MyClassInterface myClass;

        DemoInvocationHandler(MyClassInterface myClass) {
            this.myClass = myClass;
            isMethodHasLogAnnotation();
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (methodsWithAnnotationLog.contains(method.getName())) {
                System.out.println("executed method: " + method.getName() + ", param: " + Arrays.toString(args));
            }
            return method.invoke(myClass, args);
        }

        public void isMethodHasLogAnnotation() {
            Method[] methods = myClass.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Log.class)) {
                    methodsWithAnnotationLog.add(method.getName());
                }
            }
        }
    }
}
