package com.xuhai.androiddesignpattern.q_proxy;

import java.lang.reflect.Proxy;

public class ProxyClient {

    public static void test() {
        ILawsuit farm = new Farm();
        ILawsuit lawsuit = new Lawyer(farm);
        lawsuit.submit();
        lawsuit.burden();
        lawsuit.defend();
        lawsuit.finish();
    }

    public static void test2() {
        ILawsuit farm = new Farm();

        //构造一个动态代理
        DynamicProxy proxy = new DynamicProxy(farm);
        //获取被代理类的CLassLoader
        ClassLoader loader = farm.getClass().getClassLoader();
        //动态生成代理类
        ILawsuit lawsuit = (ILawsuit) Proxy.newProxyInstance(loader, new Class[]{ILawsuit.class}, proxy);

        lawsuit.submit();
        lawsuit.burden();
        lawsuit.defend();
        lawsuit.finish();

    }

}
