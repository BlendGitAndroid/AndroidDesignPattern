package com.blend.androiddesignpattern.g_state;

public class TvController implements PowerController {

    private TvState mTvState;

    private void setTvState(TvState tvState) {
        mTvState = tvState;
    }

    @Override
    public void powerOn() {
        setTvState(new PowerOnState());
    }

    @Override
    public void powerOff() {
        setTvState(new PowerOffState());
    }

    public void preChannel() {
        mTvState.preChannel();
    }

    public void nextChannel() {
        mTvState.nextChannel();
    }

    public void turnUp() {
        mTvState.turnUp();
    }

    public void turnDown() {
        mTvState.turnDown();
    }
}
