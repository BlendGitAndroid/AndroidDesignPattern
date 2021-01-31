package com.blend.androiddesignpattern.b_builder;

/**
 * 建造者模式就是将对象的创建和表示分离。
 * build就是用来创建对象，利用调用链避免了过多的setter方法，在调用build的时候构建对象。
 * 构建者模式的好处是你可以随意set属性而不需要关心这些值的顺序，因为这些顺序在Build对象里面自己处理了。
 * 构建后对象的属性就随着你的框架设计而设计了，你也可以重新赋值，也可以不赋值只能得到属性。
 */
public class Director {

    Builder mBuilder = null;

    /**
     * @param builder
     */
    public Director(Builder builder) {
        mBuilder = builder;
    }

    public void construct(String board, String display) {
        mBuilder.buildBoard(board);
        mBuilder.buildDisplay(display);
        mBuilder.buildOS();
    }

}
