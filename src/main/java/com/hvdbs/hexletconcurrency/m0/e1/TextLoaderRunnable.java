package com.hvdbs.hexletconcurrency.m0.e1;

import com.hvdbs.hexletconcurrency.m0.e0.TextLoader;

public class TextLoaderRunnable implements Runnable {

    private TextLoader textLoader;

    public TextLoaderRunnable(TextLoader textLoader) {
        this.textLoader = textLoader;
    }

    @Override
    public void run() {
        System.out.println(textLoader.loadText());
    }
}

