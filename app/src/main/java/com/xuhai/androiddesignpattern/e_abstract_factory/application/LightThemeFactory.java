package com.xuhai.androiddesignpattern.e_abstract_factory.application;

import android.content.Context;

public class LightThemeFactory extends AbstractThemeFactory {

    public LightThemeFactory(Context context) {
        super(context);
    }

    @Override
    public ThemeButton createButton() {
        return null;
    }

    @Override
    public ThemeToolbar createToolbar() {
        return null;
    }
}
