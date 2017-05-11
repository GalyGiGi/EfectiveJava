package cn.com.lbb.effectjava.Generic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zengcheng on 2017/5/7.
 * <p>
 * 利用有限制通配符提升api灵活度
 */

public class Test4 {
    private void test() {
        Set<Integer> e1 = new HashSet<>();
        Set<Double> e2 = new HashSet<>();
//        Set<Number> set = union(e1,e2);//编译不过
        Set<Integer> e = union(e1, e1);
        Set<Number> set = this.<Number>union(e1, e2);
    }

    private static <E> Set<E> union(Set<? extends E> e1, Set<? extends E> e2) {//不要用通配符类型作为返回类型
        return null;
    }

    private <E> E reduce(List<? extends E> list, Test2.Function<? super E> function, E initVal) {//生产者使用extends,消费者使用super
        return null;
    }

    private <E> void put(E key, E value) {

    }
}
