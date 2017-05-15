package cn.com.lbb.effectjava.Enum;

import java.util.EnumSet;

/**
 * Created by zengcheng on 2017/5/12.
 */

public class Test1 {


    public static void main(String[] args) {
        setBeer(Beer.PINK_KILLER);
    }

    private static void setBeer(Beer beer) {
//        System.out.printf("alcoholDegree %s", beer.getAlcoholDegree());
        for (Beer b : Beer.values()) {
            System.out.printf("beer: %s alcoholDegree %s%n", b.toString(), b.getAlcoholDegree());
        }
        EnumSet.of(Beer.PINK_KILLER, Beer.WHITE_BEER);
    }

}
