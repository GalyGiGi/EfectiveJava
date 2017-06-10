package cn.com.lbb.effectjava.Chapter10.item70;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by zengcheng on 2017/6/3.
 * 线程对立的类,永远不能在多线程条件下安全使用??
 * !!!!未实现
 */

public class ThreadOpposition {
    private static int sNameCount = 0;
    private String name;
    private static int LOOP_COUNT = 10000;

    public String getName() {
        sNameCount++;
        return name;
    }

    public int setNameCount() {
        sNameCount = 1;
        return sNameCount;
    }

    public static void checkNameCount() {
        if (sNameCount == 0) {
            System.out.print("sNameCount==0," + sNameCount + "\n");
//            System.out.print("\n");
        }
        sNameCount = 0;
    }

    public static void main(String[] args) {
        ThreadOpposition opposition = new ThreadOpposition();
        Object lock = new Object();
        Executor executor = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10; i++) {
            Runnable setter = new CountSetter(opposition, lock);
            executor.execute(setter);
            Runnable getter = new CountGetter(opposition, lock);
            executor.execute(getter);
        }
    }

    static class CountSetter implements Runnable {
        ThreadOpposition mOpp;
        Object mLock;

        CountSetter(ThreadOpposition opposition, Object lock) {
            mOpp = opposition;
            mLock = lock;
        }

        @Override
        public void run() {
            int cont = 0;
            while (cont < LOOP_COUNT) {
                synchronized (mLock) {
                    mOpp.setNameCount();
                }
                cont++;
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class CountGetter implements Runnable {
        ThreadOpposition mOpp;
        Object mLock;

        CountGetter(ThreadOpposition opposition, Object lock) {
            mOpp = opposition;
            mLock = lock;

        }

        @Override
        public void run() {
            int cont = 0;
            while (cont < LOOP_COUNT) {
                synchronized (mLock) {
                checkNameCount();
                }
                cont++;
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
