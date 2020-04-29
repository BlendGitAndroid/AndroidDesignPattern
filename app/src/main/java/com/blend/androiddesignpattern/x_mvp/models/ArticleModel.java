package com.blend.androiddesignpattern.x_mvp.models;

import android.database.Cursor;

import com.blend.androiddesignpattern.x_mvp.entities.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleModel extends AbsDBAPI<Article> {


    public ArticleModel(String table) {
        super(table);
    }

    @Override
    protected String loadDatasOrderBy() {
        return "public_time DESC";
    }

    @Override
    protected List<Article> parseResult(Cursor cursor) {
        List<Article> articles = new ArrayList<Article>();
        while (cursor.moveToNext()) {
            Article item = new Article();
            item.post_id = cursor.getString(0);
            item.author = cursor.getString(1);
            item.title = cursor.getString(2);
            item.category = cursor.getInt(3);
            item.publishTime = cursor.getString(4);
            // 解析数据
            articles.add(item);
        }
        return articles;
    }
}
