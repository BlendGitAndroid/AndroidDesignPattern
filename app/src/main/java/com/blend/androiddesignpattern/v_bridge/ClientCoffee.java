package com.blend.androiddesignpattern.v_bridge;

/**
 * 桥接模式，将抽象部分与实现部分分离，使他们可以独立的进行变化。
 * 这里的抽象部分指的是变化的维度，有几个维度就有几个抽象部分，然后具体的实现将这几个抽象的维度关联起来。
 * 能将继承关系转变为关联关系。
 */
public class ClientCoffee {

    public static void test() {
        CoffeeAdditives ordinary = new Ordinary();
        CoffeeAdditives sugar = new Sugar();

        LargeCoffee largeCoffee = new LargeCoffee(sugar);
        largeCoffee.makeCoffee();

        SmallCoffee smallCoffee = new SmallCoffee(ordinary);
        smallCoffee.makeCoffee();
    }

}
