package com.xuhai.androiddesignpattern.k_observer.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Subscriber {

    /**
     * 事件的tag,类似于BroadcastReceiver中的Action,事件的标识符
     *
     * @return
     */
    String tag() default EventType.DEFAULT_TAG;

    /**
     * 事件执行的线程,默认为主线程
     *
     * @return
     */
    ThreadMode mode() default ThreadMode.MAIN;

}
