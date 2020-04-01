package com.xuhai.androiddesignpattern.c_prototype;

public class Client {

    public static void test() {
        //构建对象
        WordDocument originDoc = new WordDocument();
        //编辑文档，添加图片等
        originDoc.mText = "这是一篇文档";
        originDoc.mImages.add("图片1");
        originDoc.mImages.add("图片2");
        originDoc.mImages.add("图片3");
        originDoc.showDocument();

        //以原始文档为原型，拷贝一份副本
        WordDocument doc2 = null;
        try {
            doc2 = (WordDocument) originDoc.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        doc2.showDocument();
        //修改文档副本，不会影响原始文档
        doc2.mText = "这是修改过的文档";
        doc2.mImages.add("哈哈哈");
        doc2.showDocument();

        originDoc.showDocument();
    }

}
