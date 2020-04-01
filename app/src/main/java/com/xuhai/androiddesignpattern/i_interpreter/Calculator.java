package com.xuhai.androiddesignpattern.i_interpreter;

import java.util.Stack;

public class Calculator {

    //声明一个Stack栈存储并操作所有相关的解释器
    private Stack<ArithmeticExpression> mExpStack = new Stack<>();

    public Calculator(String expression) {
        ArithmeticExpression exp1, exp2;
        String[] elements = expression.split(" ");
        for (int i = 0; i < elements.length; i++) {
            switch (elements[i].charAt(0)) {
                case '+':
                    exp1 = mExpStack.pop();
                    exp2 = new NumExpression(Integer.valueOf(elements[++i]));
                    mExpStack.push(new AdditionExpression(exp1, exp2));
                    break;
                default:
                    mExpStack.push(new NumExpression(Integer.valueOf(elements[i])));
                    break;
            }
        }
    }

    public int calcute() {
        return mExpStack.pop().interpret();
    }

}
