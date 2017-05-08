package cn.com.lbb.effectjava.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 数组是协变的,可以具体化的,泛型是不可变的,且可以擦除的
 * Created by zengcheng on 2017/4/23.
 */

public class Test2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        String initial = "initial";
        String result = reduceError(list, new Function<String>() {
            @Override
            public String apply(String t1, String t2) {
                return t1 + t2;
            }
        }, initial);
    }

    private static <T> T reduce(List<T> list, Function<T> function, T initial) {
        synchronized (list) {
            T[] sanpshot = (T[]) list.toArray(); //看似OK,但是这里会得到一个警告Unchecked cast,表明虽然可以运行,但是不安全,例子见reduceError方法
            T result = initial;
            for (T t : sanpshot) {
                result = function.apply(result, t);
            }
            return result;
        }
    }

    private static <T> T reduceError(List<T> list, Function<T> function, T initial) {
        synchronized (list) {
            T[] sanpshot = (T[]) list.toArray(); //看似OK,但是这里会得到一个警告Unchecked cast,表明虽然可以运行,但是不安全,例子见reduceError方法

            //注意此步操作,稍加修改就可以给sanpshot数组中放入任意类型的对象,造成运行时抛出异常,非常不安全
            //此处不用类型转换,因为数组是协变的
            //数组提供运行时的类型安全,却没有编译期的类型安全
            Object[] array = sanpshot;
            array[0] = 3;
            //

            T result = initial;
            for (T t : sanpshot) {
                result = function.apply(result, t);
            }
            return result;
        }
    }

    /**
     * 正确的使用方式,用list替换array
     *
     * @param list
     * @param function
     * @param initial
     * @param <T>
     * @return
     */
    private static <T> T reduceRight(List<T> list, Function<T> function, T initial) {
        synchronized (list) {
            List<T> sanpshot;
            synchronized (list) {
                sanpshot = new ArrayList<>(list);
            }

//            List<Object> objectList = list; //编译不过。因为泛型不是协变的,泛型提供了编译期的类型安全
            T result = initial;
            for (T t : sanpshot) {
                result = function.apply(result, t);
            }
            return result;
        }
    }

    interface Function<T> {
        T apply(T t1, T t2);
    }
}
