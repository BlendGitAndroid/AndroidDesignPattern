package com.blend.androiddesignpattern.k_observer.demo;

/**
 * 观察者模式：将观察者与被观察者解耦，当被观察者改变的时候，自动通知观察者做出相应的更改。
 * 这种观察者模式通常都是一对多的依赖关系，一个被观察者可以订阅多个观察者。
 * 如LiveData，RxJava，EventBus。
 * Java官方的被观察者Observable类和观察者Observer接口，看了源代码就是回调。
 * Observable订阅观察者，就是将这些观察者放到内部的一个数组中，当调用notifyObservers改变时，
 * 依次遍历这个数组，利用Observer回调实现监听。
 * 感觉就是setOnListener一样。
 * 而LiveData是包装了观察者和被观察者，观察者会观察被观察者的生命周期变化，但是onChanged方法是在
 * LiveData内部回调的。
 * 观察者模式就是有多个接收者的回调模式。
 */
public class ObserverClient {

    public static void test() {
        DevTechFrontier frontier = new DevTechFrontier();
        Coder coder = new Coder("徐海");
        frontier.addObserver(coder);

        Coder coder1 = new Coder("徐洋");
        frontier.addObserver(coder1);

        frontier.postNewPublication("最新的更新");
    }

}
