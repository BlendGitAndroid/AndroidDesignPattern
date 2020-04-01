package com.xuhai.androiddesignpattern.e_abstract_factory.demo;

public class NormalBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("普通制动");
    }
}
