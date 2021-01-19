package com.blend.androiddesignpattern.t_decorator;

import android.util.Log;

public class SinglePerson extends Person {

    public SinglePerson(String name) {
        super(name);
    }

    @Override
    public void show() {
        Log.e(TAG, "show: 我是真正的实现");
    }
}
