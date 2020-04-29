package com.blend.androiddesignpattern.a_singleton;

public class DoubleCheckLockSingleton {

    private static volatile DoubleCheckLockSingleton singleton;

    private DoubleCheckLockSingleton() {
    }

    public static DoubleCheckLockSingleton getInstance() {
        if (singleton == null) {   //这个判空是为了避免不必要的同步
            synchronized (DoubleCheckLockSingleton.class) {   //是为了在null的情况下创建实例
                if (singleton == null) {
                    singleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return singleton;
    }
}
