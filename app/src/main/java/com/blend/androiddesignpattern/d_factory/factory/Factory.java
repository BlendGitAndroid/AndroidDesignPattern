package com.blend.androiddesignpattern.d_factory.factory;

import com.blend.androiddesignpattern.d_factory.product.Product;

public abstract class Factory {

    /*
    抽象工厂方法，具体生产什么由
     */
    public abstract Product createProduct();

    /*
    抽象工厂方法，使用反射的方式来生产具体的对象
     */
    public abstract <T extends Product> T createProduct(Class<T> clz);

}
