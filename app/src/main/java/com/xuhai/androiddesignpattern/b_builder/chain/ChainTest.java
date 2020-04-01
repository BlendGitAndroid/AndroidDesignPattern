package com.xuhai.androiddesignpattern.b_builder.chain;

public class ChainTest {

    public static void main(String[] args) {
        ChainComputer computer = new ChainComputer.ChainBuilder().setBoard("华硕主板").build();
        System.out.println(computer.toString());
    }

}
