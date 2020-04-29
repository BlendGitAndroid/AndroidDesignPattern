package com.blend.androiddesignpattern.e_abstract_factory.demo;

public class SUVTire implements ITire {
    @Override
    public void tire() {
        System.out.println("越野轮胎");
    }
}
