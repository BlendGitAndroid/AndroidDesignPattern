package com.blend.androiddesignpattern.f_strategy;

/**
 * 策略模式，个人觉得就是使用依赖倒置，面向接口，将一系列相似的算法使用接口封装起来，他们可以互相替换，避免频繁的
 * 使用if...else...给项目带来难以维护的问题。
 * <p>
 * 这个模式就是用来分离在相同抽象行为下有不同的实现策略，很好的演示了开闭原则。
 * <p>
 * <p>
 * 状态模式：当一个对象的内在状态改变而改变其行为，这个对象开起来是改变了其类。
 * 一个对象的行为取决于它的状态，并在运行时动态决定。
 * 如果一个操作中含有大量的if...else...，并且这些分支依赖于其状态。
 * <p>
 * <p>
 * 状态模式和策略模式的结构完全一样，但是其目的、本质完全不同。
 * 状态模式行为是平行的，不可替换的，一般都有先后顺序。
 * 策略模式行为是彼此独立的，可替换的。
 */
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
