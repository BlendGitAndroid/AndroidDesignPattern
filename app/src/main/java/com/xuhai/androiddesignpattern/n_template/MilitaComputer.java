package com.xuhai.androiddesignpattern.n_template;

import android.util.Log;

public class MilitaComputer extends AbstractComputer {

    @Override
    protected void login() {
        Log.e(TAG, "军人登录");
    }

    @Override
    protected void checkHardware() {
        Log.e(TAG, "军人超级防火墙");
    }
}
