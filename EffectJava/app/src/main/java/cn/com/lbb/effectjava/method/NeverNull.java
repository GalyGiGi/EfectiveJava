package cn.com.lbb.effectjava.method;

import java.util.Collections;
import java.util.List;

/**
 * Created by zengcheng on 2017/5/21.
 *
 *
 * 返回0长度的数组或者集合,而不是null
 */

public class NeverNull {

    /**
     * 返回长度为0的数组,而不要返回null
     *
     * @param a
     * @return
     */
    public static int[] getArray(int[] a) {
        int[] emptyResult = new int[0];
        if (a == null) {
            return emptyResult;
        }
        return a;
    }

    public static <E> List<E> getCollection(List<E> input) {
        List<E> EMPTY = Collections.EMPTY_LIST;
        if (input == null) {
            return EMPTY;
        }
        return input;
    }
}
