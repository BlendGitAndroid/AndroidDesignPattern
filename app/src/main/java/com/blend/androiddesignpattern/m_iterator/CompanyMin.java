package com.blend.androiddesignpattern.m_iterator;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

public class CompanyMin implements Company {

    private List<Employee> list = new ArrayList<>();

    public CompanyMin() {
        list.add(new Employee("民工1号", 10));
        list.add(new Employee("民工2号", 20));
        list.add(new Employee("民工3号", 30));
        list.add(new Employee("民工4号", 40));
    }

    public List<Employee> getList() {
        return list;
    }

    @Override
    public Iterator iterator() {
        return new MinIterator(list);
    }

    AsyncTask mAsyncTask;
}
