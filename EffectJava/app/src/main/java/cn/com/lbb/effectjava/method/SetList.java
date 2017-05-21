package cn.com.lbb.effectjava.method;// What does this program print? - Page 194

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 慎用重载
 */
public class SetList {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
//            list.remove((Integer) i);//注意和这种方式的区别

        }

        System.out.println(set + " " + list);
    }

}
