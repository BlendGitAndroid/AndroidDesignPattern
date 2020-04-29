package com.blend.androiddesignpattern.d_factory.factory;

import com.blend.androiddesignpattern.d_factory.product.ConcreteProductA;
import com.blend.androiddesignpattern.d_factory.product.Product;

public class StaticFactoty {
    public static Product createProduct() {
        return new ConcreteProductA();
    }
}
