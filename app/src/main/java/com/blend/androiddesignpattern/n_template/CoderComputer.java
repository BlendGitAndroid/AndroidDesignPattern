package com.blend.androiddesignpattern.n_template;

import android.util.Log;

public class CoderComputer extends AbstractComputer {

    @Override
    protected void checkHardware() {
        Log.e(TAG, "程序员硬件自检");
    }
}
