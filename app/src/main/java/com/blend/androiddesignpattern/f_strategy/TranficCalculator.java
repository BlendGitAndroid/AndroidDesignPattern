package com.blend.androiddesignpattern.f_strategy;

public class TranficCalculator {

    private CalculateStrategy mStrategy;

    public static void test() {
        TranficCalculator calculator = new TranficCalculator();
        calculator.setStraregy(new SubwayStrategy());
        calculator.calculatePrice(12);
    }

    public void setStraregy(CalculateStrategy straregy) {
        mStrategy = straregy;
    }

    public int calculatePrice(int km) {
        return mStrategy.calculatePrice(km);
    }

}
