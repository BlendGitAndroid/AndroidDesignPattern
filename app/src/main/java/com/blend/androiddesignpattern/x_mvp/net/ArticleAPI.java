package com.blend.androiddesignpattern.x_mvp.net;

import com.blend.androiddesignpattern.x_mvp.entities.Article;
import com.blend.androiddesignpattern.x_mvp.listeners.DataListener;

import java.util.List;

import javax.xml.transform.ErrorListener;

public interface ArticleAPI {

    /**
     * 根据分类获取文章
     *
     * @param listener 监听器
     */
    public void fetchArticles(DataListener<List<Article>> listener);

    /**
     * 获取某篇文章的内容
     *
     * @param post_id  文章id
     * @param listener
     */
    public void fetchArticleContent(String post_id, DataListener<String> listener,
                                    ErrorListener errorListener);

    /**
     * 加载更多文章
     *
     * @param category 分类
     * @param listener
     */
    public void loadMore(int category, DataListener<List<Article>> listener,
                         ErrorListener errorListener);

}
