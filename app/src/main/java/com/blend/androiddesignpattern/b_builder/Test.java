package com.blend.androiddesignpattern.b_builder;

public class Test {

    public void loadData() {
        Builder builder = new MacbookBuilder();
        Director pcDirector = new Director(builder);   //组合关系
        pcDirector.construct("英特尔主板", "显示器");
    }

}
