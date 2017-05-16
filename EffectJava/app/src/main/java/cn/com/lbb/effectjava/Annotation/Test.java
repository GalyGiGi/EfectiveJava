package cn.com.lbb.effectjava.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zengcheng on 2017/5/15.
 */

public class Test {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface TestAnno {

    }

    @TestAnno
    static void m1() {

    }
}
