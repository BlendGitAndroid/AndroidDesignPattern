package com.xuhai.androiddesignpattern.e_abstract_factory.application;

import android.content.Context;

public class Test {

    public static void test(Context context) {
        AbstractThemeFactory darkThemeFactory = new DarkThemeFactory(context);
        darkThemeFactory.createButton().initBackgroundColor();
        darkThemeFactory.createButton().initTextColor();
    }

}
