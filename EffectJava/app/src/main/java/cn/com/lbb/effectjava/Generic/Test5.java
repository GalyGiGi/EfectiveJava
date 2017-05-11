package cn.com.lbb.effectjava.Generic;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zengcheng on 2017/5/11.
 */

public class Test5 {
    public static void main(String[] args) {
        new Test5().test();
    }

    private void test() {
        Set<Integer> set = new HashSet<>();
        Set rawSet = new HashSet();
        Set set1 = Collections.checkedSet(rawSet, Integer.class);
        rawSet.add("123");
//        set1.add("124");//会抛异常
    }
}
