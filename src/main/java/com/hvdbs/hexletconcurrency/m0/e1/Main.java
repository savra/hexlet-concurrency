package com.hvdbs.hexletconcurrency.m0.e1;

import com.hvdbs.hexletconcurrency.m0.e0.MockLoader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long before = System.currentTimeMillis();
        Runnable loader = new TextLoaderRunnable(new MockLoader("thread1"));

        final Thread thread = new Thread(loader);

        thread.start();

        long after =  System.currentTimeMillis();

        System.out.printf("time delta: %d\n", (after - before) / 1_000);

    }
}
