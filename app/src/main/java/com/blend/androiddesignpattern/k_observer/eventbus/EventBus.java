package com.blend.androiddesignpattern.k_observer.eventbus;

import android.util.Log;

import com.blend.androiddesignpattern.k_observer.eventbus.handler.AsyncEventHandler;
import com.blend.androiddesignpattern.k_observer.eventbus.handler.DefaultEventHandler;
import com.blend.androiddesignpattern.k_observer.eventbus.handler.EventHandler;
import com.blend.androiddesignpattern.k_observer.eventbus.handler.UIThreadEventHandler;
import com.blend.androiddesignpattern.k_observer.eventbus.matchpolicy.DefaultMatchPolicy;
import com.blend.androiddesignpattern.k_observer.eventbus.matchpolicy.MatchPolicy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public final class EventBus {
    /**
     * default descriptor
     */
    private static final String DESCRIPTOR = EventBus.class.getSimpleName();

    /**
     * 事件总线描述符描述符
     */
    private String mDesc = DESCRIPTOR;

    /**
     * EventType-Subcriptions map
     */
    private final Map<EventType, CopyOnWriteArrayList<Subscription>> mSubcriberMap = new ConcurrentHashMap<EventType, CopyOnWriteArrayList<Subscription>>();
    /**
     *
     */
    private List<EventType> mStickyEvents = Collections
            .synchronizedList(new LinkedList<EventType>());
    /**
     * the thread local event queue, every single thread has it's own queue.
     */
    ThreadLocal<Queue<EventType>> mLocalEvents = new ThreadLocal<Queue<EventType>>() {
        protected java.util.Queue<EventType> initialValue() {
            return new ConcurrentLinkedQueue<EventType>();
        }

        ;
    };

    /**
     * the event dispatcher
     */
    EventDispatcher mDispatcher = new EventDispatcher();

    /**
     * the subscriber method hunter, find all of the subscriber's methods
     * annotated with @Subcriber
     */
    SubsciberMethodHunter mMethodHunter = new SubsciberMethodHunter(mSubcriberMap);

    /**
     * The Default EventBus instance
     */
    private static EventBus sDefaultBus;

    /**
     * private Constructor
     */
    private EventBus() {
        this(DESCRIPTOR);
    }

    /**
     * constructor with desc
     *
     * @param desc the descriptor of eventbus
     */
    public EventBus(String desc) {
        mDesc = desc;
    }

    /**
     * @return
     */
    public static EventBus getDefault() {
        if (sDefaultBus == null) {
            synchronized (EventBus.class) {
                if (sDefaultBus == null) {
                    sDefaultBus = new EventBus();
                }
            }
        }
        return sDefaultBus;
    }

    /**
     * register a subscriber into the mSubcriberMap, the key is subscriber's
     * method's name and tag which annotated with {@see Subcriber}, the value is
     * a list of Subscription.
     *
     * @param subscriber the target subscriber
     */
    public void register(Object subscriber) {
        if (subscriber == null) {
            return;
        }

        synchronized (this) {
            mMethodHunter.findSubcribeMethods(subscriber);
        }
    }

    /**
     * 以sticky的形式注册,则会在注册成功之后迭代所有的sticky事件
     *
     * @param subscriber
     */
    public void registerSticky(Object subscriber) {
        this.register(subscriber);
        // 处理sticky事件
        mDispatcher.dispatchStickyEvents(subscriber);
    }

    /**
     * @param subscriber
     */
    public void unregister(Object subscriber) {
        if (subscriber == null) {
            return;
        }
        synchronized (this) {
            mMethodHunter.removeMethodsFromMap(subscriber);
        }
    }

    /**
     * post a event
     *
     * @param event
     */
    public void post(Object event) {
        post(event, EventType.DEFAULT_TAG);
    }

    /**
     * 发布事件
     *
     * @param event 要发布的事件
     * @param tag   事件的tag, 类似于BroadcastReceiver的action
     */
    public void post(Object event, String tag) {
        if (event == null) {
            Log.e(this.getClass().getSimpleName(), "The event object is null");
            return;
        }
        mLocalEvents.get().offer(new EventType(event.getClass(), tag));
        mDispatcher.dispatchEvents(event);
    }

    /**
     * 发布Sticky事件,tag为EventType.DEFAULT_TAG
     *
     * @param event
     */
    public void postSticky(Object event) {
        postSticky(event, EventType.DEFAULT_TAG);
    }

    /**
     * 发布含有tag的Sticky事件
     *
     * @param event 事件
     * @param tag   事件tag
     */
    public void postSticky(Object event, String tag) {
        if (event == null) {
            Log.e(this.getClass().getSimpleName(), "The event object is null");
            return;
        }
        EventType eventType = new EventType(event.getClass(), tag);
        eventType.event = event;
        mStickyEvents.add(eventType);
    }

    public void removeStickyEvent(Class<?> eventClass) {
        removeStickyEvent(eventClass, EventType.DEFAULT_TAG);
    }

    /**
     * 移除Sticky事件
     *
     * @param tag
     */
    public void removeStickyEvent(Class<?> eventClass, String tag) {
        Iterator<EventType> iterator = mStickyEvents.iterator();
        while (iterator.hasNext()) {
            EventType eventType = iterator.next();
            if (eventType.paramClass.equals(eventClass)
                    && eventType.tag.equals(tag)) {
                iterator.remove();
            }
        }
    }

    public List<EventType> getStickyEvents() {
        return mStickyEvents;
    }

    /**
     * 设置订阅函数匹配策略
     *
     * @param policy 匹配策略
     */
    public void setMatchPolicy(MatchPolicy policy) {
        mDispatcher.mMatchPolicy = policy;
    }

    /**
     * 设置执行在UI线程的事件处理器
     *
     * @param handler
     */
    public void setUIThreadEventHandler(EventHandler handler) {
        mDispatcher.mUIThreadEventHandler = handler;
    }

    /**
     * 设置执行在post线程的事件处理器
     *
     * @param handler
     */
    public void setPostThreadHandler(EventHandler handler) {
        mDispatcher.mPostThreadHandler = handler;
    }

    /**
     * 设置执行在异步线程的事件处理器
     *
     * @param handler
     */
    public void setAsyncEventHandler(EventHandler handler) {
        mDispatcher.mAsyncEventHandler = handler;
    }

    /**
     * 返回订阅map
     *
     * @return
     */
    public Map<EventType, CopyOnWriteArrayList<Subscription>> getSubscriberMap() {
        return mSubcriberMap;
    }

    /**
     * 获取等待处理的事件队列
     *
     * @return
     */
    public Queue<EventType> getEventQueue() {
        return mLocalEvents.get();
    }

    /**
     * clear the events and subcribers map
     */
    public synchronized void clear() {
        mLocalEvents.get().clear();
        mSubcriberMap.clear();
    }

    /**
     * get the descriptor of EventBus
     *
     * @return the descriptor of EventBus
     */
    public String getDescriptor() {
        return mDesc;
    }

    public EventDispatcher getDispatcher() {
        return mDispatcher;
    }

    /**
     * 事件分发器
     *
     * @author mrsimple
     */
    private class EventDispatcher {

        /**
         * 将接收方法执行在UI线程
         */
        EventHandler mUIThreadEventHandler = new UIThreadEventHandler();

        /**
         * 哪个线程执行的post,接收方法就执行在哪个线程
         */
        EventHandler mPostThreadHandler = new DefaultEventHandler();

        /**
         * 异步线程中执行订阅方法
         */
        EventHandler mAsyncEventHandler = new AsyncEventHandler();

        /**
         * 缓存一个事件类型对应的可EventType列表
         */
        private Map<EventType, List<EventType>> mCacheEventTypes = new ConcurrentHashMap<EventType, List<EventType>>();
        /**
         * 事件匹配策略,根据策略来查找对应的EventType集合
         */
        MatchPolicy mMatchPolicy = new DefaultMatchPolicy();

        /**
         * @param aEvent
         */
        void dispatchEvents(Object aEvent) {
            Queue<EventType> eventsQueue = mLocalEvents.get();
            while (eventsQueue.size() > 0) {
                deliveryEvent(eventsQueue.poll(), aEvent);
            }
        }

        /**
         * 根据aEvent查找到所有匹配的集合,然后处理事件
         *
         * @param type
         * @param aEvent
         */
        private void deliveryEvent(EventType type, Object aEvent) {
            // 如果有缓存则直接从缓存中取
            List<EventType> eventTypes = getMatchedEventTypes(type, aEvent);
            // 迭代所有匹配的事件并且分发给订阅者
            for (EventType eventType : eventTypes) {
                handleEvent(eventType, aEvent);
            }
        }

        /**
         * 处理单个事件
         *
         * @param eventType
         * @param aEvent
         */
        private void handleEvent(EventType eventType, Object aEvent) {
            List<Subscription> subscriptions = mSubcriberMap.get(eventType);
            if (subscriptions == null) {
                return;
            }

            for (Subscription subscription : subscriptions) {
                final ThreadMode mode = subscription.threadMode;
                EventHandler eventHandler = getEventHandler(mode);
                // 处理事件
                eventHandler.handleEvent(subscription, aEvent);
            }
        }

        private List<EventType> getMatchedEventTypes(EventType type, Object aEvent) {
            List<EventType> eventTypes = null;
            // 如果有缓存则直接从缓存中取
            if (mCacheEventTypes.containsKey(type)) {
                eventTypes = mCacheEventTypes.get(type);
            } else {
                eventTypes = mMatchPolicy.findMatchEventTypes(type, aEvent);
                mCacheEventTypes.put(type, eventTypes);
            }

            return eventTypes != null ? eventTypes : new ArrayList<EventType>();
        }

        void dispatchStickyEvents(Object subscriber) {
            for (EventType eventType : mStickyEvents) {
                handleStickyEvent(eventType, subscriber);
            }
        }

        /**
         * 处理单个Sticky事件
         *
         * @param eventType
         * @param subscriber
         */
        private void handleStickyEvent(EventType eventType, Object subscriber) {
            List<EventType> eventTypes = getMatchedEventTypes(eventType, eventType.event);
            // 事件
            Object event = eventType.event;
            for (EventType foundEventType : eventTypes) {
                Log.e("", "### 找到的类型 : " + foundEventType.paramClass.getSimpleName()
                        + ", event class : " + event.getClass().getSimpleName());
                final List<Subscription> subscriptions = mSubcriberMap.get(foundEventType);
                if (subscriptions == null) {
                    continue;
                }
                for (Subscription subItem : subscriptions) {
                    final ThreadMode mode = subItem.threadMode;
                    EventHandler eventHandler = getEventHandler(mode);
                    // 如果订阅者为空,那么该sticky事件分发给所有订阅者.否则只分发给该订阅者
                    if (isTarget(subItem, subscriber)
                            && (subItem.eventType.equals(foundEventType)
                            || subItem.eventType.paramClass
                            .isAssignableFrom(foundEventType.paramClass))) {
                        // 处理事件
                        eventHandler.handleEvent(subItem, event);
                    }
                }
            }
        }

        /**
         * 如果传递进来的订阅者不为空,那么该Sticky事件只传递给该订阅者(注册时),否则所有订阅者都传递(发布时).
         *
         * @param item
         * @param subscriber
         * @return
         */
        private boolean isTarget(Subscription item, Object subscriber) {
            Object cacheObject = item.subscriber != null ? item.subscriber.get() : null;
            return subscriber == null || (subscriber != null
                    && cacheObject != null && cacheObject.equals(subscriber));
        }

        private EventHandler getEventHandler(ThreadMode mode) {
            if (mode == ThreadMode.ASYNC) {
                return mAsyncEventHandler;
            }
            if (mode == ThreadMode.POST) {
                return mPostThreadHandler;
            }
            return mUIThreadEventHandler;
        }
    } // end of EventDispatcher
}
