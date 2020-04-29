package com.blend.androiddesignpattern.e_abstract_factory.demo;

public abstract class CarFactory {

    public abstract ITire creteTire();

    public abstract IEngine createEngine();

    public abstract IBrake createNrake();

}
