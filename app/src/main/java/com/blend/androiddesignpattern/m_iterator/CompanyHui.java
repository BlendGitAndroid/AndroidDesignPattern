package com.blend.androiddesignpattern.m_iterator;

public class CompanyHui implements Company {

    private Employee[] array = new Employee[3];

    public CompanyHui() {
        array[0] = new Employee("灰机1号", 10);
        array[1] = new Employee("灰机2号", 20);
        array[2] = new Employee("灰机3号", 30);
    }

    public Employee[] getArray() {
        return array;
    }

    @Override
    public Iterator iterator() {
        return new HuiIterator(array);
    }
}
