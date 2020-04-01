package com.xuhai.androiddesignpattern.d_factory.demo2;

public abstract class IOHandler {

    /*
    id:身份证号码
    String：名字
     */

    //增
    public abstract void add(String id, String name);

    //删
    public abstract void remove(String id);

    //改
    public abstract void update(String id, String name);

    //查
    public abstract String query(String id);

}
