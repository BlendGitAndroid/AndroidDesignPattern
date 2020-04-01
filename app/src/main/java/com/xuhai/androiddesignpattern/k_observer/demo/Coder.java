package com.xuhai.androiddesignpattern.k_observer.demo;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Observable;
import java.util.Observer;


public class Coder implements Observer {

    protected static final String TAG = "Coder";

    private String name;

    public Coder(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.e(TAG, "更新name: " + name + "内容：" + arg);
    }

    @NonNull
    @Override
    public String toString() {
        return "码农" + name;
    }
}
