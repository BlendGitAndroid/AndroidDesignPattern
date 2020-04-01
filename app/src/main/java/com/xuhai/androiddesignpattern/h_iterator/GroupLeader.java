package com.xuhai.androiddesignpattern.h_iterator;

import android.util.Log;

public class GroupLeader extends Leader {

    private static final String TAG = "GroupLeader";

    @Override
    public int limit() {
        return 1000;
    }

    @Override
    public void handle(int money) {
        Log.e(TAG, "组长报销: " + money);
    }
}
