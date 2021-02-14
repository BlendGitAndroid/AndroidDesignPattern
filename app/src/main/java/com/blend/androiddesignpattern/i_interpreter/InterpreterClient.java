package com.blend.androiddesignpattern.i_interpreter;

import android.util.Log;

/**
 * 解释器模式：定义一种文法，并定义一个解释器，该解释器使用该表示来解释语言中的例子。
 * Android源码中的解释器模式就是解析mxl文件，就是解释器模式。
 */
public class InterpreterClient {

    private static final String TAG = "InterpreterClient";

    public static void test() {
        Calculator c = new Calculator("1 + 3 + 5 + 7");
        Log.e(TAG, "test: " + c.calcute());
    }

}
