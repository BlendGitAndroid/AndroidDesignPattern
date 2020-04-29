package com.blend.androiddesignpattern.b_builder;

public class Macbook extends Computer {

    protected Macbook() {
    }

    @Override
    public void setOS() {
        mOS = "Mac OS X 10.10";
    }
}
