package com.xuhai.androiddesignpattern.e_abstract_factory.application;

import android.content.Context;
import android.util.Log;

public class ButtonDark extends ThemeButton {

    private static final String TAG = "ButtonDark";

    public ButtonDark(Context context) {
        super(context);
    }

    @Override
    protected void initBackgroundColor() {
        Log.e(TAG, "initBackgroundColor");
    }

    @Override
    protected void initTextColor() {
        Log.e(TAG, "initTextColor");
    }
}
