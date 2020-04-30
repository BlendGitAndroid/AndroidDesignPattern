package com.blend.androiddesignpattern.x_mvp.optimize;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/*
    View类型通过BasePresenter的泛型类型传递进来，Presenter对这个类只有弱引用，通常情况下，这个View类型应该就是实现了某个特定
    接口的Activity和Fragment等类型。
 */
public abstract class BasePresenter<T> {

    protected Reference<T> mViewRef;

    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);   //通过View的弱引用建立关联
    }

    protected T getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
