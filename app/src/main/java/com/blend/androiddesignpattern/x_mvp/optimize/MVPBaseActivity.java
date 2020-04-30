package com.blend.androiddesignpattern.x_mvp.optimize;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public abstract class MVPBaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity {

    /*
        V:View接口类型
        T:Presenter的具体类型
     */
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView(getView());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();

    protected abstract V getView();
}
