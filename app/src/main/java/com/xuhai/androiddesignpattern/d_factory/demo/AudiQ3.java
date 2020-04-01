package com.xuhai.androiddesignpattern.d_factory.demo;

import android.util.Log;

public class AudiQ3 extends AudiCar {

    private static final String TAG = "AudiQ3";

    @Override
    public void drive() {
        Log.e(TAG, "drive: Q3");
    }

    @Override
    public void selfNavigation() {
        Log.e(TAG, "selfNavigation: Q3");
    }
}
