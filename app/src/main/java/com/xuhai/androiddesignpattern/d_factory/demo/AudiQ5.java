package com.xuhai.androiddesignpattern.d_factory.demo;

import android.util.Log;

public class AudiQ5 extends AudiCar {

    private static final String TAG = "AudiQ5";

    @Override
    public void drive() {
        Log.e(TAG, "drive: Q5");
    }

    @Override
    public void selfNavigation() {
        Log.e(TAG, "selfNavigation: Q5");
    }
}
