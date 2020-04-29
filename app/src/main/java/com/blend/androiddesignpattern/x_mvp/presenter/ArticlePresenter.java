package com.blend.androiddesignpattern.x_mvp.presenter;

import com.blend.androiddesignpattern.x_mvp.entities.Article;
import com.blend.androiddesignpattern.x_mvp.listeners.DataListener;
import com.blend.androiddesignpattern.x_mvp.net.ArticleAPI;
import com.blend.androiddesignpattern.x_mvp.net.ArticleAPIImpl;
import com.blend.androiddesignpattern.x_mvp.models.ArticleModel;
import com.blend.androiddesignpattern.x_mvp.ui.ArticleViewInterface;

import java.util.List;

//Presenter，作为View和Model的中间人
public class ArticlePresenter {

    //View接口角色
    ArticleViewInterface mArticleView;

    //Model角色
    ArticleModel mArticleModel = new ArticleModel("测试");

    //从网络上获取文章的API
    ArticleAPI mArticleAPI = new ArticleAPIImpl();

    public ArticlePresenter(ArticleViewInterface viewInterface) {
        mArticleView = viewInterface;
    }

    //获取文章，也就是业务逻辑
    public void fetchArticles() {
        mArticleView.showLoading();
        mArticleAPI.fetchArticles(new DataListener<List<Article>>() {
            @Override
            public void onComplete(List<Article> result) {
                mArticleView.showArticles(result);
                mArticleView.hideLoading();
                mArticleModel.saveItems(result);
            }
        });
    }

    public void loadArticlesFromDB() {
        mArticleModel.loadDatasFromDB(new DataListener<List<Article>>() {
            @Override
            public void onComplete(List<Article> result) {
                mArticleView.showArticles(result);
            }
        });
    }

}
