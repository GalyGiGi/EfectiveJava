package cn.com.lbb.effectjava.NestedClass;

import java.util.Comparator;

/**
 * Created by zengcheng on 2017/4/23.
 */

public class EnclosingClass {
    /**
     * 定义在一个类内部的类叫嵌套类,嵌套类有四种,静态成员类,非静态成员类,匿名类,局部类,除了第一种,其余三种也叫内部类
     * 内部类不允许存在静态成员
     */

    private int mOutterid;
    private final static int ID = 0;

    private static int getId() {
        return ID;
    }

    private static class StaticMemberClass {//静态成员类,可以有静态成员,不能访问外部类的成员
        static final int ID = 0;

        private int getOutterId() {//只能访问外部类的静态属性,静态方法
            getId();
            return ID;
        }
    }

    public class MemberClass {//非静态成员类,可以有静态成员,能访问外部类的成员
        static final int ID = 1;

        public int getOutterId() {//能访问外部类的成员
            return mOutterid;
        }
    }

    public static final Comparator<String> STRING_COMPARATOR = new Comparator<String>() {//匿名类
        //static int id;                                  //不能拥有静态成员
        @Override
        public int compare(String lhs, String rhs) {
            return 0;
        }
    };

    public void nestedLocalClass() {
        class LocalClass {                    //局部类,拥有局部变量一样的作用域
            //static  int id;                 //不能拥有静态成员
        }
    }
}
