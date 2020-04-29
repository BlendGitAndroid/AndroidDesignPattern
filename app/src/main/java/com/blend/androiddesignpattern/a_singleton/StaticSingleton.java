package com.blend.androiddesignpattern.a_singleton;

public class StaticSingleton {

    private StaticSingleton() {
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final StaticSingleton sInstance = new StaticSingleton();
    }
}
