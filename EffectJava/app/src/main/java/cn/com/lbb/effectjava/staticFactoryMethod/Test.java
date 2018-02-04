package cn.com.lbb.effectjava.staticFactoryMethod;

import java.util.HashMap;

/**
 * Created by zengcheng on 2017/6/24.
 */

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> map = newMap();
        HashMap<String, String> map2 = new HashMap<>();
        String  a=null;
        if(a instanceof String){
            System.out.print("null instanceof String");
        }else{
            System.out.print("!!! null instanceof String");

        }
    }

    public static <K, V> HashMap<K, V> newMap() {
        return new HashMap<K, V>();
    }
}
