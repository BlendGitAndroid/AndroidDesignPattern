package com.xuhai.androiddesignpattern.j_command;

import android.util.Log;

/**
 * 接收者角色，处理具体的逻辑
 */
public class TetrisMachine {

    protected static final String TAG = "TetrisMachine";

    public void toLeft() {
        Log.e(TAG, "toLeft");
    }

    public void toRight() {
        Log.e(TAG, "toRight");
    }

    public void fastToBottom() {
        Log.e(TAG, "fastToBottom");
    }

    public void transform() {
        Log.e(TAG, "transform");
    }
}
