package cn.com.lbb.effectjava.Chapter10.Item67;// Simple test of ObservableSet - Page 266

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        ObservableSet<Integer> set =
            new ObservableSet<Integer>(new HashSet<Integer>());

        set.addObserver(new SetObserver<Integer>() {
                public void added(ObservableSet<Integer> s, Integer e) {
                    System.out.println(e);
            }
        });

        for (int i = 0; i < 100; i++)
            set.add(i);


        Set<Integer> testSet= new HashSet<>();
        for (int i = 0; i < 100; i++)
            testSet.add(i);
        for(Integer i:testSet){
            if(i==3){
                testSet.remove(5);
            }
        }

    }
}
