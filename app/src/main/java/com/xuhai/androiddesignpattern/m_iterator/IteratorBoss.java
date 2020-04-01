package com.xuhai.androiddesignpattern.m_iterator;

import android.util.Log;

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
