package com.blend.androiddesignpattern.q_proxy.demo;

import java.lang.reflect.Proxy;

/**
 * 代理模式：委托模式。
 * 对其他对象提供一个代理，以控制对这个对象的访问。在某些情况下，一个对象不适合或者不能直接引用另外一个对象，而代理对象
 * 可以在客户端和目标对象直接起到中介的作用。
 * 代理分为静态代理和动态代理。
 * 代理模式：被代理对象和代理对象都要继承同一个接口。
 *
 * 动态代理：通过反射机制，在运行时动态的获取。
 */
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
