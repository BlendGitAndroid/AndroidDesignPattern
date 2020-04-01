package com.xuhai.androiddesignpattern.x_mvp.net;

import com.xuhai.androiddesignpattern.x_mvp.entities.Article;
import com.xuhai.androiddesignpattern.x_mvp.listeners.DataListener;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;

public class ArticleAPIImpl implements ArticleAPI {

    @Override
    public void fetchArticles(DataListener<List<Article>> listener) {
        listener.onComplete(new ArrayList<Article>());
    }

    @Override
    public void fetchArticleContent(String post_id, DataListener<String> listener, ErrorListener errorListener) {

    }

    @Override
    public void loadMore(int category, DataListener<List<Article>> listener, ErrorListener errorListener) {

    }
}
