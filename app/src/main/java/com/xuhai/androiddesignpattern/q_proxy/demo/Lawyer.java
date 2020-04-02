package com.xuhai.androiddesignpattern.q_proxy.demo;

public class Lawyer implements ILawsuit {

    private ILawsuit mLawsuit;

    public Lawyer(ILawsuit lawsuit) {
        mLawsuit = lawsuit;
    }

    @Override
    public void submit() {
        mLawsuit.submit();
    }

    @Override
    public void burden() {
        mLawsuit.burden();
    }

    @Override
    public void defend() {
        mLawsuit.defend();
    }

    @Override
    public void finish() {
        mLawsuit.finish();
    }
}
