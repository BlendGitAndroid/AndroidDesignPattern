package com.blend.androiddesignpattern.b_builder;

import androidx.annotation.NonNull;

//计算机抽象类，即Product角色
public abstract class Computer {

    protected String mBoard;
    protected String mDisplay;
    protected String mOS;

    protected Computer() {
    }

    //设置主板
    public void setBoard(String board) {
        mBoard = board;
    }

    //设置显示器
    public void setDisplay(String display) {
        mDisplay = display;
    }

    public abstract void setOS();

    @NonNull
    @Override
    public String toString() {
        return "Computer [mBoard=" + mBoard + ",mDisplay=" + mDisplay + ",mOS" + mOS + "]";
    }
}
