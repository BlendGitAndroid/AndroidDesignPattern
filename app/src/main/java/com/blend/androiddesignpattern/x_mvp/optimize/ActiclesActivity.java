package com.blend.androiddesignpattern.x_mvp.optimize;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.blend.androiddesignpattern.R;
import com.blend.androiddesignpattern.x_mvp.entities.Article;
import com.blend.androiddesignpattern.x_mvp.ui.ArticleViewInterface;

import java.util.ArrayList;
import java.util.List;

public class ActiclesActivity extends MVPBaseActivity<ArticleViewInterface, ArticlePresenterV2> implements ArticleViewInterface {

    private List<Article> mArticles = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articles_layout);
        mPresenter.fetchArticles();
    }

    @Override
    protected ArticlePresenterV2 createPresenter() {
        return new ArticlePresenterV2();  //去掉强引用，全部都是用弱引用
    }

    @Override
    public void showArticles(List<Article> articles) {
        mArticles.addAll(articles);
        System.out.println("展示文章");
    }

    @Override
    public void showLoading() {
        System.out.println("开始弹窗");
    }

    @Override
    public void hideLoading() {
        System.out.println("结束弹窗");
    }

}
