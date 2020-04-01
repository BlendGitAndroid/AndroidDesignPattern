package com.xuhai.androiddesignpattern.d_factory.client;

import com.xuhai.androiddesignpattern.d_factory.factory.ConcreteFactory;
import com.xuhai.androiddesignpattern.d_factory.factory.Factory;
import com.xuhai.androiddesignpattern.d_factory.product.ConcreteProductA;
import com.xuhai.androiddesignpattern.d_factory.product.Product;

public class Client {
    public static void test() {
        Factory factory = new ConcreteFactory();
        Product p = factory.createProduct();
        p.method();

        Product pClass = factory.createProduct(ConcreteProductA.class);
        pClass.method();

    }
}
