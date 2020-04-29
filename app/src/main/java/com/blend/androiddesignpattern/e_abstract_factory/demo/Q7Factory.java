package com.blend.androiddesignpattern.e_abstract_factory.demo;

public class Q7Factory extends CarFactory {
    @Override
    public ITire creteTire() {
        return new SUVTire();
    }

    @Override
    public IEngine createEngine() {
        return new ImportEngine();
    }

    @Override
    public IBrake createNrake() {
        return new SeniorBrake();
    }
}
