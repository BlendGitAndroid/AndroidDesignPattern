package com.blend.androiddesignpattern.v_bridge;

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
