package com.xuhai.androiddesignpattern.d_factory.product;

import android.util.Log;

public class ConcreteProductA extends Product {

    private static final String TAG = "ConcreteProductA";

    @Override
    public void method() {
        Log.d(TAG, "我是产品A");
    }
}
