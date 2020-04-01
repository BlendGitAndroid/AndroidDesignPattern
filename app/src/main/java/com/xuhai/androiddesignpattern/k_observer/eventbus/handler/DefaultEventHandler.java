package com.xuhai.androiddesignpattern.k_observer.eventbus.handler;

import com.xuhai.androiddesignpattern.k_observer.eventbus.Subscription;

import java.lang.reflect.InvocationTargetException;

public class DefaultEventHandler implements EventHandler{
    /**
     * handle the event
     *
     * @param subscription
     * @param event
     */
    public void handleEvent(Subscription subscription, Object event) {
        if (subscription == null
                || subscription.subscriber.get() == null) {
            return;
        }
        try {
            // 执行
            subscription.targetMethod.invoke(subscription.subscriber.get(), event);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
