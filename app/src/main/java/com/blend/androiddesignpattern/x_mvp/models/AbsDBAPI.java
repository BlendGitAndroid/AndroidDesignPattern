package com.blend.androiddesignpattern.x_mvp.models;

import android.content.ContentValues;
import android.database.Cursor;

import com.blend.androiddesignpattern.x_mvp.listeners.DataListener;

import java.util.List;

public abstract class AbsDBAPI<T> {

    /**
     * 表名
     */
    protected String mTableName;

    public AbsDBAPI(String table) {
        mTableName = table;
    }

    /**
     * 保存数据
     *
     * @param item
     */
    public void saveItem(final T item) {
        System.out.println(mTableName + "---保存数据");
    }

    protected ContentValues toContentValues(T item) {
        return null;
    }

    /**
     * 保存数据到数据库
     */
    public void saveItems(List<T> datas) {
        for (T item : datas) {
            saveItem(item);
        }
    }

    /**
     * 加载所有缓存
     *
     * @param listener
     */
    public void loadDatasFromDB(DataListener<List<T>> listener) {
        System.out.println(mTableName + "---加载缓存");
    }

    protected String loadDatasOrderBy() {
        return "";
    }

    /**
     * 从Cursor中解析数据
     *
     * @param cursor
     * @return
     */
    protected List<T> parseResult(Cursor cursor) {
        return null;
    }

    /**
     * 删除符合特定条件的数据
     */
    public void deleteWithWhereArgs(final String whereArgs) {
        System.out.println(mTableName + "---删除数据");
    }

}
