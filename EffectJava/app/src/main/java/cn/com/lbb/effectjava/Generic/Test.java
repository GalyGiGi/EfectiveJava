package cn.com.lbb.effectjava.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengcheng on 2017/4/23.
 * <p>
 * <p>
 * 不要在新代码中使用原始类型,而应是使用泛型。除了两个例外,class literal和instanceof
 */

public class Test {
    public static void main(String[] args) {
        arrayUnsafe();
        getMyClass(null);
        List<String> list = new ArrayList<>();
        unsafeAdd(list, 30);
//        unsafeAdd1(list, 30); //不能编译,因为List<String> 并不是List<Object> 的子类
        safeAdd2(list, "s"); //可以编译,因为List<String> 是List<? extends Object> 的子类
        String s = list.get(0);
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        unsafeNumInCommon(l1, l2);
        safeNumInCommon(l1, l2);
//        safeNumInCommon2(l1,l2);//编译不过,只能使用同一类型
    }


    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    private static <T extends Object> void safeAdd1(List<T> list, T t) {
        list.add(t);
    }

    private static void unsafeAdd1(List<Object> list, Object o) {
        list.add(o);
        list.add("");
    }

    private static void safeAdd2(List<? extends Object> list, String o) {
//        list.add(3);  //编译不过
        list.add(null); //ok
    }

    private static void arrayUnsafe() {
        Object[] array = new String[5];//编译通过,但是导致了把int放入到String数组里
        array[0] = 3;
    }

    private static void genericSafe() {
//        List<Object> list =new ArrayList<String>();//编译不过,避免了错误
    }

    private static void genericArray() {
//        Object[] array = new List<String>[5]; //创建泛型数组是非法的
        Object[] array1 = new List<?>[5];
        Object[] array2 = new List[5];

    }

    private static int unsafeNumInCommon(List l1, List l2) {
        int num = 0;
        for (Object o : l1) {
            if (l2.contains(o)) {
                num++;
            }
        }
        return num;
    }

    private static int safeNumInCommon(List<?> l1, List<?> l2) {
        int num = 0;
        for (Object o : l1) {
            if (l2.contains(o)) {
                num++;
            }
        }
        return num;
    }

    private static <E> int safeNumInCommon2(List<E> l1, List<E> l2) {
        int num = 0;
        for (Object o : l1) {
            if (l2.contains(o)) {
                num++;
            }
        }
        return num;
    }

    /**
     * 由于泛型信息运行期擦除,所以使用class literal有限制
     *
     * @param list
     */
    private static void getMyClass(List<?> list) {
//        list.getClass();
        String name = List.class.getName();
        name = int.class.getName();
        name = null;
//        List<String>.class.getName(); //非法
    }

    /**
     * 由于泛型信息运行期擦除,所以使用instanceof有限制
     *
     * @param o
     * @return
     */
    private static boolean instanceOf(Object o) {
//        return o instanceof List<String>; //非法
//        return o instanceof List<? extends String>; //非法


//        return o instanceof List; //合法

        return o instanceof List<?>; //合法,相当于上面的语句
    }

    /**
     * 对于泛型类的标准类型检查规范
     *
     * @param o
     */
    private static void typicalCheck(Object o) {
        if (o instanceof List) {
            List<?> list = (List<?>) o;
        }
    }
}
