package com.xuhai.androiddesignpattern.h_chainofresponsibiliity;

import android.util.Log;

public class Manager extends Leader {

    private static final String TAG = "Manager";
    
    @Override
    public int limit() {
        return 10000;
    }

    @Override
    public void handle(int money) {
        Log.e(TAG, "经理报销: " + money);
    }
}
