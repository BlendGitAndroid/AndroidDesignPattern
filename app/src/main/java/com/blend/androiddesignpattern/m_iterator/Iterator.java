package com.blend.androiddesignpattern.m_iterator;

public interface Iterator {

    /**
     * 是否有下一个元素
     * @return true表示有，false表示没有
     */
    boolean hasNext();

    /**
     * 返回当前位置的元素，并将位置移至下一位
     */
    Object next();

}
