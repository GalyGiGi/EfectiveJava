package cn.com.lbb.effectjava.Annotaion;

import java.lang.reflect.Method;

/**
 * Created by zengcheng on 2017/5/17.
 */

public class RunTests2 {
    public static void main(String[] args) throws ClassNotFoundException {
        int passed = 0;
        int test = 0;
        Class testClass = Class.forName("cn.com.lbb.effectjava.Annotaion.Sample2");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                test++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed:no exception %n", m);
                } catch (Throwable e) {
                    Throwable exc = e.getCause();
                    Class<? extends Exception>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
                    int oldPassed = passed;
                    for (Class<? extends Exception> exception : excTypes) {
                        if (exception.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (oldPassed == passed) {
                        System.out.printf("TEST %S IS FAILD: %s %n", m, exc);
                    }
//                    e.printStackTrace();
                }
            }
        }
    }
}
