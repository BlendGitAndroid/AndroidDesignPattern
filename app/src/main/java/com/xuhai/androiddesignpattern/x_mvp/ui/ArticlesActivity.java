package com.xuhai.androiddesignpattern.x_mvp.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xuhai.androiddesignpattern.R;
import com.xuhai.androiddesignpattern.x_mvp.entities.Article;
import com.xuhai.androiddesignpattern.x_mvp.presenter.ArticlePresenter;

import java.util.ArrayList;
import java.util.List;


public class ArticlesActivity extends AppCompatActivity implements ArticleViewInterface {

    private ArticlePresenter mPresenter;
    private List<Article> mArticles = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articles_layout);
        mPresenter = new ArticlePresenter(this);
        mPresenter.fetchArticles();
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
