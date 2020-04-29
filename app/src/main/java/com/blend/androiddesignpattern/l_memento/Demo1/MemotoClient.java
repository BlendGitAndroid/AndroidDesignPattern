package com.blend.androiddesignpattern.l_memento.Demo1;

public class MemotoClient {

    public static void test() {

        CallOfDuty game = new CallOfDuty(); //构建游戏对象
        game.play();    //打游戏

        Caretaker caretaker = new Caretaker();
        caretaker.archive(game.createMemoto()); //游戏存档
        game.quit();    //退出游戏

        CallOfDuty newGame = new CallOfDuty();
        newGame.restore(caretaker.getMemoto()); //恢复游戏
    }

}
