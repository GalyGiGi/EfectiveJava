package cn.com.lbb.effectjava.Generic;// Typesafe heterogeneous container - Pages 142-145

import java.util.*;

public class Favorites {
    // Typesafe heterogeneous container pattern - implementation
    private Map<Class<?>, Object> favorites =
            new HashMap<Class<?>, Object>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null)
            throw new NullPointerException("Type is null");
        favorites.put(type, instance);
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }


    // Typesafe heterogeneous container pattern - client
    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString,
                favoriteInteger, favoriteClass.getName());
        //局限性：1.恶意客户端可以轻松的破坏类型安全，只要使用原生态形式的class对象就行
        //解决方法:在put方法中检验传入的类型 favorites.put(type,type.cast(instance));
        Class c = String.class;//只要
        f.putFavorite(c, 3);
        //局限2：不能用在不可具体化的类型中，例如List<String>,因为List<String>.class是个语法错误
    }
}