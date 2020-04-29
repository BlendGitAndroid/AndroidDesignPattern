package com.blend.androiddesignpattern.e_abstract_factory.demo;

public class NormalTire implements ITire {


    @Override
    public void tire() {
        System.out.println("普通轮胎");
    }
}
