package com.xuhai.androiddesignpattern.p_mediator;

public class CDDevice extends Colleague {

    private String data;    //视频数据

    public CDDevice(Mediator mediator) {
        super(mediator);
    }

    public String getData() {
        return data;
    }

    public void load() {
        data = "视频数据,音频数据";
        mMediator.changed(this);
    }

}
