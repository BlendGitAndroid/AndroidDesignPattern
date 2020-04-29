package com.blend.androiddesignpattern.a_singleton;

public class Singleton {

    /*
    懒汉式，开始还没有，比较懒，需要的再去实例化
     */

    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
