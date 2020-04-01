package com.xuhai.androiddesignpattern.n_template;

import android.util.Log;

import static com.xuhai.androiddesignpattern.n_template.AbstractComputer.TAG;

public class TemplateClient {

    public static void test() {
        AbstractComputer computer = new CoderComputer();
        computer.startUp();

        Log.e(TAG, " ");

        computer = new MilitaComputer();
        computer.startUp();
    }

}
