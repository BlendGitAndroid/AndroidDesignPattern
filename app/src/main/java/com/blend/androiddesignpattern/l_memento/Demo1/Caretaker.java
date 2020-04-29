package com.blend.androiddesignpattern.l_memento.Demo1;

public class Caretaker {

    Memoto mMemoto; //备忘录

    /*
    存档
     */
    public void archive(Memoto memoto) {
        mMemoto = memoto;
    }

    /*
    获取存档
     */
    public Memoto getMemoto() {
        return mMemoto;
    }

}
