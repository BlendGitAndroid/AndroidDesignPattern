package com.xuhai.androiddesignpattern.k_observer.eventbus.handler;

import com.xuhai.androiddesignpattern.k_observer.eventbus.Subscription;

public interface EventHandler {

    /**
     * 处理事件
     *
     * @param subscription 订阅对象
     * @param event 待处理的事件
     */
    void handleEvent(Subscription subscription, Object event);

}
