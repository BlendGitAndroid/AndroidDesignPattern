package com.xuhai.androiddesignpattern.a_singleton;

import android.util.Log;

public enum SingletonEnum {

    INSTANCE;
    public void doSomething() {
        Log.e("SingletonEnum", "doSomething: ");
    }
}
