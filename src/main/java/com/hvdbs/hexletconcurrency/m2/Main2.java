package com.hvdbs.hexletconcurrency.m2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> submit = executorService.submit(new SumCallable(1, 2));

        System.out.println(submit.get());

        executorService.shutdown();
    }
}
