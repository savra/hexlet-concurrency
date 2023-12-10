package com.hvdbs.hexletconcurrency.m2;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SumCallable implements Callable<Integer> {
    final int a;
    final int b;

    public SumCallable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return a + b;
    }
}
