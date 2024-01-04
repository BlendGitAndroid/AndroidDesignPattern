package com.blend.androiddesignpattern.f_strategy;

public class SubwayStrategy implements CalculateStrategy {


    /*
    地铁价格计算
     */
    @Override
    public int calculatePrice(int km) {
        if (km <= 6) {
            return 3;
        } else if (km <= 12) {
            return 4;
        } else if (km <= 22) {
            return 5;
        } else {
            return 6;
        }
    }
}
