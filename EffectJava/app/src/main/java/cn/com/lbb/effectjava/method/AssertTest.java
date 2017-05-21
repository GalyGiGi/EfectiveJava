package cn.com.lbb.effectjava.method;

/**
 * Created by zengcheng on 2017/5/20.
 *
 *
 * 对于公有方法,如果参数有限制,应该在文档中写清楚,并在方法的开始处进行检查,并抛出适当的异常
 * 对于包内可见的方法,自己可以控制方法调用时传入的参数,可以使用assert断言
 */

public class AssertTest {
    public static void main(String[] args) {
        long[] test = new long[5];
        sort(null, 3, 4);
    }

    private static void sort(long[] a, int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
    }

    /**
     * @param a        非空
     * @param index    索引值必须合法
     * @param newValue
     */
    public static void replace(long[] a, int index, long newValue) throws IllegalArgumentException, NullPointerException {
        if (a == null) throw new NullPointerException("long[] can not be null");
        if (index < 0 || index >= a.length) throw new IllegalArgumentException("index illegal");
        a[index] = newValue;
    }
}
