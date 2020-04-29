package com.blend.androiddesignpattern.i_interpreter;

import android.util.Log;

public class InterpreterClient {

    private static final String TAG = "InterpreterClient";

    public static void test() {
        Calculator c = new Calculator("1 + 3 + 5 + 7");
        Log.e(TAG, "test: " + c.calcute());
    }

}
