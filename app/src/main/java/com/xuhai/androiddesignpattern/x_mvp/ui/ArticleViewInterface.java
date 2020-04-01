package com.xuhai.androiddesignpattern.x_mvp.ui;

import com.xuhai.androiddesignpattern.x_mvp.entities.Article;

import java.util.List;

public interface ArticleViewInterface {

    public void showArticles(List<Article> articles);   //展示数据

    public void showLoading();      //显示进度条

    public void hideLoading();      //隐藏进度条

}
