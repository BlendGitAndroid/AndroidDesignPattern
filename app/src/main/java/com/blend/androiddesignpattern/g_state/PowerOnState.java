package com.blend.androiddesignpattern.g_state;

import android.util.Log;

public class PowerOnState implements TvState {

    private static final String TAG = "PowerOnState";

    @Override
    public void nextChannel() {
        Log.e(TAG, "nextChannel");
    }

    @Override
    public void preChannel() {
        Log.e(TAG, "preChannel");
    }

    @Override
    public void turnUp() {
        Log.e(TAG, "turnUp");
    }

    @Override
    public void turnDown() {
        Log.e(TAG, "turnDown");
    }
}
