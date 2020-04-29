package com.blend.androiddesignpattern.e_abstract_factory.application;

import android.content.Context;

public abstract class AbstractThemeFactory {

    protected Context context;

    public AbstractThemeFactory(Context context) {
        this.context = context;
    }

    /*
    创建主题按钮
     */
    public abstract ThemeButton createButton();

    /*
    创建主题标题栏
     */
    public abstract ThemeToolbar createToolbar();
}
