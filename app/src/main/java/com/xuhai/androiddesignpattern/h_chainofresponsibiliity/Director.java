package com.xuhai.androiddesignpattern.h_chainofresponsibiliity;

import android.util.Log;

public class Director extends Leader {

    private static final String TAG = "Director";

    @Override
    public int limit() {
        return 5000;
    }

    @Override
    public void handle(int money) {
        Log.e(TAG, "主管报销: " + money);
    }
}
