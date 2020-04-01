package com.xuhai.androiddesignpattern.d_factory.demo;

public abstract class AudiFactory {

    /*
    某车型的抽象方法
     */
    public abstract <T extends AudiCar> T createAudiCar(Class<T> clz);

}
