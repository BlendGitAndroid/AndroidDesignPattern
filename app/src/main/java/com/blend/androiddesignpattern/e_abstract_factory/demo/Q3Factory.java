package com.blend.androiddesignpattern.e_abstract_factory.demo;

public class Q3Factory extends CarFactory {
    @Override
    public ITire creteTire() {
        return new NormalTire();
    }

    @Override
    public IEngine createEngine() {
        return new DomesticEngine();
    }

    @Override
    public IBrake createNrake() {
        return new NormalBrake();
    }
}
