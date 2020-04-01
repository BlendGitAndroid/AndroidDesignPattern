package com.xuhai.androiddesignpattern.e_abstract_factory.application;

import android.content.Context;

public class DarkThemeFactory extends AbstractThemeFactory {


    public DarkThemeFactory(Context context) {
        super(context);
    }

    @Override
    public ThemeButton createButton() {
        return new ButtonDark(context);
    }

    @Override
    public ThemeToolbar createToolbar() {
        return new ToolbarDark(context);
    }
}
