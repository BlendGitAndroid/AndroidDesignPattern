package com.blend.androiddesignpattern.p_mediator;

public abstract class Colleague {

    protected Mediator mMediator;      //每一个同事都应该知道中介者

    public Colleague(Mediator mediator) {
        mMediator = mediator;
    }

}
