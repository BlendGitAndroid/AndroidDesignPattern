package com.blend.androiddesignpattern.o_visitor.demo;

import java.util.Random;

public abstract class Staff {

    public String name;

    // 员工KPI
    public int kpi;

    public Staff(String aName) {
        this.name = aName;
        kpi = new Random().nextInt(10);
    }
    // 接受Visitor的访问
    public abstract void accept(Visitor visitor);

}
