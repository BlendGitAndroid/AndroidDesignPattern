package com.blend.androiddesignpattern.j_command;

public class Buttons {

    private LeftCommand mLeftCommand;
    private RightCommand mRightCommand;

    public void setLeftCommand(LeftCommand command) {
        mLeftCommand = command;
    }

    public void setRightCommand(RightCommand command) {
        mRightCommand = command;
    }

    public void toLeft() {
        mLeftCommand.execute();
    }

    public void toRight() {
        mRightCommand.execute();
    }

}
