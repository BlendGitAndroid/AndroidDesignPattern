package com.blend.androiddesignpattern.d_factory.demo;

import android.util.Log;

public class AudiQ7 extends AudiCar {

    private static final String TAG = "AudiQ7";

    @Override
    public void drive() {
        Log.e(TAG, "drive: Q7");
    }

    @Override
    public void selfNavigation() {
        Log.e(TAG, "selfNavigation: Q7");
    }
}
