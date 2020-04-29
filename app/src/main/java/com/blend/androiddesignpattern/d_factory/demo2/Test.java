package com.blend.androiddesignpattern.d_factory.demo2;

import android.util.Log;

public class Test {

    private static final String TAG = "Test";

    public static void test() {
        String id = IOFactory.getIOHandler(DBHandler.class).query("12581");
        Log.e(TAG, "test: " + id);
    }


}
