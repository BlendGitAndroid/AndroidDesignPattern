package com.blend.androiddesignpattern.k_observer.eventbus.handler;

import android.os.Handler;
import android.os.HandlerThread;

import com.blend.androiddesignpattern.k_observer.eventbus.Subscription;

public class AsyncEventHandler implements EventHandler {
    /**
     * 事件分发线程
     */
    DispatcherThread mDispatcherThread;

    /**
     * 事件处理器
     */
    EventHandler mEventHandler = new DefaultEventHandler();

    public AsyncEventHandler() {
        mDispatcherThread = new DispatcherThread(AsyncEventHandler.class.getSimpleName());
        mDispatcherThread.start();
    }

    /**
     * 将订阅的函数执行在异步线程中
     *
     * @param subscription
     * @param event
     */
    public void handleEvent(final Subscription subscription, final Object event) {
        mDispatcherThread.post(new Runnable() {

            @Override
            public void run() {
                mEventHandler.handleEvent(subscription, event);
            }
        });
    }

    /**
     * @author mrsimple
     */
    class DispatcherThread extends HandlerThread {

        /**
         * 关联了AsyncExecutor消息队列的Handler
         */
        protected Handler mAsyncHandler;

        /**
         * @param name
         */
        public DispatcherThread(String name) {
            super(name);
        }

        /**
         * @param runnable
         */
        public void post(Runnable runnable) {
            if (mAsyncHandler == null) {
                throw new NullPointerException("mAsyncHandler == null, please call start() first.");
            }

            mAsyncHandler.post(runnable);
        }

        @Override
        public synchronized void start() {
            super.start();
            mAsyncHandler = new Handler(this.getLooper());
        }

    }

}
