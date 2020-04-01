package com.xuhai.androiddesignpattern.e_abstract_factory.application;

import android.content.Context;
import android.util.Log;

public class ToolbarDark extends ThemeToolbar {

    private static final String TAG = "ToolbarDark";

    public ToolbarDark(Context context) {
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

    @Override
    protected void initIcon() {
        Log.e(TAG, "initIcon");
    }
}
