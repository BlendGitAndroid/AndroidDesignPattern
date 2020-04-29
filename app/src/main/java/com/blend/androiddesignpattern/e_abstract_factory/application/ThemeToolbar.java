package com.blend.androiddesignpattern.e_abstract_factory.application;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toolbar;

@SuppressLint("NewApi")
public abstract class ThemeToolbar extends Toolbar {

    public ThemeToolbar(Context context) {
        super(context);
        initIcon();
        initTextColor();
        initBackgroundColor();
    }

    /*
    初始化背景颜色
     */
    protected abstract void initBackgroundColor();

    /*
    初始化文本颜色
     */
    protected abstract void initTextColor();

    /*
    初始化图标
     */
    protected abstract void initIcon();
}
