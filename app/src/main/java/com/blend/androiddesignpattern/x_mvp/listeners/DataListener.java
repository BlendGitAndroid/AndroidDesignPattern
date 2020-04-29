package com.blend.androiddesignpattern.x_mvp.listeners;

/**
 * 通用数据Listener
 *
 * @author mrsimple
 * @param <T>
 */
public interface DataListener<T> {
    public void onComplete(T result);

}
