package com.hvdbs.hexletconcurrency.m2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newWorkStealingPool(3);
        SumRunnable sumRunnable = new SumRunnable(1, 2);

        Future<?> future = executorService.submit(sumRunnable);

       // future.get();
        Thread.sleep(2000);

        System.out.println(sumRunnable.getResult());
    }
}
