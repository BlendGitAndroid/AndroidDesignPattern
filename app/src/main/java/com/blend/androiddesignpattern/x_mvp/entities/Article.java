package com.blend.androiddesignpattern.x_mvp.entities;

public class Article {

    public static final int ALL = 1;
    public static final int ANDROID = 2;
    public static final int iOS = 3;
    /**
     *
     */
    public String title;
    public String publishTime;
    public String author;
    public String post_id;
    public int category;

    public Article() {
    }

    public Article(String pid) {
        post_id = pid;
    }

    @Override
    public String toString() {
        return "Article [title=" + title + ", publishTime=" + publishTime
                + ", author=" + author + ", post_id=" + post_id + ", category="
                + category + "]";
    }

}
