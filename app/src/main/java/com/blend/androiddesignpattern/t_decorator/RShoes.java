package com.blend.androiddesignpattern.t_decorator;

import android.util.Log;

public class RShoes extends Decorator {
    public RShoes(Person person) {
        super(person);
    }

    @Override
    public void show() {
        super.show();
        Log.e(TAG, "show: 穿鞋子");
    }
}
