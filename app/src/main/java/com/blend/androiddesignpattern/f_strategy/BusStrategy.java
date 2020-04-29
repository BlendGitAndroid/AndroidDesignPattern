package com.blend.androiddesignpattern.f_strategy;

public class BusStrategy implements CalculateStrategy {

    /*
    北京公交车计费，十公里之内一元，超过十公里之后每加一元可乘坐五公里
     */
    @Override
    public int calculatePrice(int km) {
        int extraTotal = km - 10;
        int extraFactory = extraTotal / 5;
        int fraction = extraFactory % 5;
        int price = 1 + extraFactory * 1;
        return fraction > 0 ? ++price : price;
    }
}
