package com.xuhai.androiddesignpattern.h_chainofresponsibiliity;

import android.util.Log;

public class Boss extends Leader {

    private static final String TAG = "IteratorBoss";

    @Override
    public int limit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void handle(int money) {
        Log.e(TAG, "老板报销: " + money);
    }
}
