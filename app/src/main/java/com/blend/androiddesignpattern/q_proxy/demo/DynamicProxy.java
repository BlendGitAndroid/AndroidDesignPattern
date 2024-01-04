package com.blend.androiddesignpattern.q_proxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class DynamicProxy implements InvocationHandler {

    private Object object;  //被代理类的引用

    public DynamicProxy(Object object) {
        this.object = object;
    }

    // this:代码自动生成的代理类
    // method:正在被调用的方法
    // args:调用方法传入的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);    //调用被代理类对象的方法
        return result;
    }
}
