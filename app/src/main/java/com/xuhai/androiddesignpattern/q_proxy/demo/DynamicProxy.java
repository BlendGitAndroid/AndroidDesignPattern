package com.xuhai.androiddesignpattern.q_proxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class DynamicProxy implements InvocationHandler {

    private Object object;  //被代理类的引用

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);    //调用被代理类对象的方法
        return result;
    }
}
