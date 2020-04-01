package com.xuhai.androiddesignpattern.j_command;

/**
 具体命令者，向右类
 */
public class RightCommand implements Command {

    private TetrisMachine mTetrisMachine;

    public RightCommand(TetrisMachine machine) {
        mTetrisMachine = machine;
    }

    @Override
    public void execute() {
        mTetrisMachine.toRight();
    }
}
