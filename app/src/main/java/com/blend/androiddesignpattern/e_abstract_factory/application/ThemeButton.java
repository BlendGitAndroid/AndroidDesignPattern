package com.blend.androiddesignpattern.e_abstract_factory.application;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Button;

@SuppressLint("AppCompatCustomView")
public abstract class ThemeButton extends Button {


    public ThemeButton(Context context) {
        super(context);
        initTextColor();
        initBackgroundColor();
    }

    /*
    初始化文本颜色
     */
    protected abstract void initBackgroundColor();

    /*
    初始化背景颜色
     */
    protected abstract void initTextColor();

}
