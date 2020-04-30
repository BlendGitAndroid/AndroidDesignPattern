package com.blend.androiddesignpattern.x_mvp.optimize;

import com.blend.androiddesignpattern.x_mvp.entities.Article;
import com.blend.androiddesignpattern.x_mvp.listeners.DataListener;
import com.blend.androiddesignpattern.x_mvp.models.ArticleModel;
import com.blend.androiddesignpattern.x_mvp.net.ArticleAPI;
import com.blend.androiddesignpattern.x_mvp.net.ArticleAPIImpl;
import com.blend.androiddesignpattern.x_mvp.ui.ArticleViewInterface;

import java.util.List;

public class ArticlePresenterV2 extends BasePresenter<ArticleViewInterface> {


    private ArticleModel mArticleModel = new ArticleModel("测试");

    private ArticleAPI mArticleAPI = new ArticleAPIImpl();


    //获取文章，也就是业务逻辑
    public void fetchArticles() {
        getView().showLoading();
        mArticleAPI.fetchArticles(new DataListener<List<Article>>() {
            @Override
            public void onComplete(List<Article> result) {
                getView().hideLoading();        //这里用弱引用来获取View
                getView().showArticles(result);
                mArticleModel.saveItems(result);
            }
        });
    }


}
