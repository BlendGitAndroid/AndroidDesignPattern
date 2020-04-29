package com.blend.androiddesignpattern.j_command;

/**
 * 具体命令者，向左类
 */
public class LeftCommand implements Command {

    private TetrisMachine mTetrisMachine;

    public LeftCommand(TetrisMachine machine) {
        mTetrisMachine = machine;
    }

    @Override
    public void execute() {
        mTetrisMachine.toLeft();
    }
}
