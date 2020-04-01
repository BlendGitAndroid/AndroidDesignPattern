package com.xuhai.androiddesignpattern.k_observer.demo;

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
