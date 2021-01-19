package com.blend.androiddesignpattern.t_decorator;

public abstract class Decorator extends Person {

    private Person mPerson;

    public Decorator(Person person) {
        mPerson = person;
    }

    @Override
    public void show() {
        mPerson.show();
    }
}
