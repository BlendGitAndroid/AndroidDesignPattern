package com.blend.androiddesignpattern.o_visitor.demo;

import java.util.Random;

public class Manager extends Staff {
    private int products;  // 产品数量

    public Manager(String aName) {
        super(aName);
        products = new Random().nextInt(10);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * 一年内做的产品数量
     */
    public int getProducts() {
        return products;
    }
}
