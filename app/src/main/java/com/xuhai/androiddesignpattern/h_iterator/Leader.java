package com.xuhai.androiddesignpattern.h_iterator;

public abstract class Leader {

    protected Leader nextHandler; //上一级领导处理着

    /*
    处理报账请求
     */
    public final void handleRequest(int money) {
        if (money <= limit()) {
            handle(money);
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(money);
            }
        }
    }

    //自身能批复的额度限制
    public abstract int limit();

    //处理报账行为
    public abstract void handle(int money);

}
