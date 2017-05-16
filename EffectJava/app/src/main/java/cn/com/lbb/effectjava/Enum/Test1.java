package cn.com.lbb.effectjava.Enum;

import java.util.EnumSet;
import java.util.Set;

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
        Set<Beer> set = EnumSet.of(Beer.PINK_KILLER, Beer.WHITE_BEER, Beer.BLACK_BEER, Beer.DUUE);
        Beer[] beers = new Beer[]{};
        beers = set.toArray(beers);
        Set<Beer> set2 = EnumSet.of(Beer.WHITE_BEER, Beer.PINK_KILLER, Beer.BLACK_BEER, Beer.DUUE);
        beers = set2.toArray(beers);
        Set<Beer> set3 = EnumSet.of(Beer.BLACK_BEER, Beer.WHITE_BEER, Beer.PINK_KILLER, Beer.DUUE);
        beers = set3.toArray(beers);

    }

}
