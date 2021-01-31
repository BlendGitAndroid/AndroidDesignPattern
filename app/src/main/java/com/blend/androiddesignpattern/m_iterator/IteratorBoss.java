package com.blend.androiddesignpattern.m_iterator;

import android.util.Log;

/**
 * 迭代器模式：游标模式。
 * 容器肯定要涉及到遍历算法，如果将遍历算法封装到容器中，容器不仅要维护内部的数据，还要对外提供遍历的接口方法，容器就承担了
 * 过多的功能，但是要是不提供遍历方法，又不行。因此就产生了迭代器模式。
 * 提供一个顺序访问一个容器对象中的各个元素，而不需要暴露该对象的内部表示。
 */
public class IteratorBoss {

    private static final String TAG = "IteratorBoss";

    public static void test() {
        CompanyMin companyMin = new CompanyMin();
        check(companyMin.iterator());

        CompanyHui companyHui = new CompanyHui();
        check(companyHui.iterator());
    }

    private static void check(Iterator iterator) {
        while (iterator.hasNext()) {
            Log.e(TAG, iterator.next().toString());
        }
    }

}
