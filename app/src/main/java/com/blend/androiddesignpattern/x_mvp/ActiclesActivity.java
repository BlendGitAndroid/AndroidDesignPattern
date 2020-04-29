package com.blend.androiddesignpattern.x_mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.blend.androiddesignpattern.R;
import com.blend.androiddesignpattern.x_mvp.entities.Article;
import com.blend.androiddesignpattern.x_mvp.ui.ArticleViewInterface;

import java.util.List;

public class ActiclesActivity extends MVPBaseActivity<ArticleViewInterface, ArticlePresenterV2<ArticleViewInterface>> implements ArticleViewInterface {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articles_layout);
    }

    @Override
    protected ArticlePresenterV2<ArticleViewInterface> createPresenter() {
        return null;
    }

    @Override
    public void showArticles(List<Article> articles) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
