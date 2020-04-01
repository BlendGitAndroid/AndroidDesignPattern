package com.xuhai.androiddesignpattern.c_prototype;

import android.util.Log;

import java.util.ArrayList;

public class WordDocument implements Cloneable {

    private static final String TAG = "WordDocument";

    //文本
    public String mText;
    //图片名列表
    public ArrayList<String> mImages = new ArrayList<>();

    public WordDocument() {
        Log.e(TAG, "WordDocument 构造函数");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        WordDocument doc = (WordDocument) super.clone();
        doc.mText = this.mText;
        doc.mImages = (ArrayList<String>) this.mImages.clone();
        return doc;
    }

    /*
    打印文档内容
     */
    public void showDocument() {
        Log.e(TAG, "---Word Content Start---");
        Log.e(TAG, "Test: " + mText);
        Log.e(TAG, "Images List: ");
        for (String imgName : mImages) {
            Log.e(TAG, "image name: " + imgName);
        }
        Log.e(TAG, "---Word Content End---");
    }
}
