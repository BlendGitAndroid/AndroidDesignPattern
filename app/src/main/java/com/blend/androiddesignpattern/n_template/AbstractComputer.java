package com.blend.androiddesignpattern.n_template;

import android.util.Log;

public abstract class AbstractComputer {

    protected static final String TAG = "AbstractComputer";

    public final void powerOn() {   //不能被重载
        Log.e(TAG, "powerOn");
    }

    protected void login() {        //可以被重载
        Log.e(TAG, "小白的电脑不需要密码");
    }

    protected abstract void checkHardware();  //需要被重写

    public final void powerOff() {      //不能被重载
        Log.e(TAG, "powerOff");
    }

    public final void startUp() {   //final修饰，流程固定
        Log.e(TAG, "---开机---");
        powerOn();
        checkHardware();
        login();
        powerOff();
        Log.e(TAG, "---关机---");
    }

}
