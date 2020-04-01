package com.xuhai.androiddesignpattern.o_visitor.demo;

import java.util.Random;

public class Engineer extends Staff {
    public Engineer(String aName) {
        super(aName) ;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * 工程师这一年写的代码行数量
     */
    public int getCodeLines() {
        return new Random().nextInt(10 * 10000);
    }
}
