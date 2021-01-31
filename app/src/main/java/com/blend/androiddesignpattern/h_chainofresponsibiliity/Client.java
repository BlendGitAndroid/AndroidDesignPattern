package com.blend.androiddesignpattern.h_chainofresponsibiliity;

/**
 * 责任链模式将请求的发送者与接收者进行解耦，为请求创建一条接收者对象的链，每个接收者都包含上一个接收者的引用。
 * 多个对象可以处理同一请求，但具体由哪个对象处理，则在运行时动态决定。
 * 客户只需要将请求发送到链上即可，并不需要关心处理者和处理细节。
 */
public class Client {

    public static void test() {
        GroupLeader groupLeader = new GroupLeader();
        Director director = new Director();
        Manager manager = new Manager();
        Boss boss = new Boss();

        groupLeader.nextHandler = director;
        director.nextHandler = manager;
        manager.nextHandler = boss;

        groupLeader.handleRequest(50000);
    }

}
