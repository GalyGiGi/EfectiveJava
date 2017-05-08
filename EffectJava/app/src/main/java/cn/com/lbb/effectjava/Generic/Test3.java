package cn.com.lbb.effectjava.Generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zengcheng on 2017/4/27.
 */

public class Test3 {
    public static void main(String[] args){
        HashMap<String,List<String>> map = getMap();//泛型方法,使用起来更方便
        map.put("zc",new ArrayList<String>());
    }


    public static <K, V> HashMap<K, V> getMap() {
        return new HashMap<>();
    }
}
