package com.hvdbs.hexletconcurrency.e0;

public class MainWithThreads {
    public static void main(String[] args) throws InterruptedException {
        final TextLoader fileTextLoader = new MockLoader("textFromFile");
        final TextLoader webTextLoader = new MockLoader("textFromWeb");
        final long before = System.currentTimeMillis();

        Thread fileTextLoaderThread = new Thread() {
            @Override
            public void run() {
                System.out.println(fileTextLoader.loadText());
            }
        };

        fileTextLoaderThread.start();

        Thread webTextLoaderThread = new Thread() {
            @Override
            public void run() {
                System.out.println(webTextLoader.loadText());
            }
        };

        webTextLoaderThread.start();

        fileTextLoaderThread.join();
        webTextLoaderThread.join();
        final long after = System.currentTimeMillis();

        System.out.printf("time delta: %d\n", (after - before) / 1_000);
    }
}
