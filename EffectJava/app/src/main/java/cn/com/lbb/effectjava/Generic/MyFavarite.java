package cn.com.lbb.effectjava.Generic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zengcheng on 2017/5/11.
 */

public class MyFavarite {
    private Map<Object, Object> mMap = new HashMap<>();

    public <E> void put(E key, E value, Class<E> type) {//必须有第三个参数才能保证key和value是同一类型
        mMap.put(key, value);
    }

//    public <E> void put(E key, E value) {//会导致类型不安全
//        mMap.put(key, value);
//    }

    public <E> E get(E key, Class<E> type) {
        return type.cast(mMap.get(key));
    }

//    public <E> E get(E key) {//会导致类型不安全
//        return (E) mMap.get(key);
//    }

    public static void main(String[] args) {
        MyFavarite f = new MyFavarite();
        f.put(new MyFavarite(), "Java", Object.class);
        f.put(1, "c++", Serializable.class);
//        f.put(2,"c#",String.class);//编译不过
//        f.put(Integer.class, 0xcafebabe);//可以随意放置任意类型的key和value，没有任何限制
//        f.put(2, Favorites.class);//可以随意放置任意类型的key和value，没有任何限制
//        f.put("3", 5);
//        int j = f.get(1);//运行会报错
//        Serializable j = f.get(1, Serializable.class);
//        String s = f.get("3");

//        String favoriteString = f.getFavorite(String.class);
//        int favoriteInteger = f.getFavorite(Integer.class);
//        Class<?> favoriteClass = f.getFavorite(Class.class);
//        System.out.printf("%s %x %s%n", favoriteString,
//                favoriteInteger, favoriteClass.getName());
        f.get(1, Integer.class);
    }
}
