package com.blend.androiddesignpattern.d_factory.product;

import android.util.Log;

public class ConcreteProductB extends Product {

    private static final String TAG = "ConcreteProductB";

    @Override
    public void method() {
        Log.d(TAG, "我是产品B");
    }
}
