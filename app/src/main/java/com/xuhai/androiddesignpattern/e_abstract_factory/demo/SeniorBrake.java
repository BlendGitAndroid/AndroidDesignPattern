package com.xuhai.androiddesignpattern.e_abstract_factory.demo;

public class SeniorBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("高级制动");
    }
}
