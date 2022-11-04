package com.hvdbs.hexletconcurrency.e0;

public class MockLoader implements TextLoader {
    private final String textToLoad;

    public MockLoader(String textToLoad) {
        this.textToLoad = textToLoad;
    }

    @Override
    public String loadText() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return textToLoad;
    }
}
