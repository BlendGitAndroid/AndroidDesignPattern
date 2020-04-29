package com.blend.androiddesignpattern.j_command;

public class Client {

    public static void test() {
        //首先要有俄罗斯方块游戏
        TetrisMachine machine = new TetrisMachine();

        //构造游戏四种命令
        LeftCommand leftCommand = new LeftCommand(machine);
        RightCommand rightCommand = new RightCommand(machine);

        //执行不同的命令
        Buttons buttons = new Buttons();
        buttons.setLeftCommand(leftCommand);
        buttons.setRightCommand(rightCommand);

        //具体的命令
        buttons.toLeft();
        buttons.toRight();
    }

    public static void test2(){
        TetrisMachine machine = new TetrisMachine();
        machine.toRight();
        machine.toLeft();
    }

}
