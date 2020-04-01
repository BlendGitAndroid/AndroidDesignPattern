package com.xuhai.androiddesignpattern.l_memento.Demo1;

/*
    备忘录类
 */
public class Memoto {

    public int mCheckPoint;
    public int mLeftValue;
    public String mWeapon;

    @Override
    public String toString() {
        return "Memoto{" +
                "mCheckPoint=" + mCheckPoint +
                ", mLeftValue=" + mLeftValue +
                ", mWeapon='" + mWeapon + '\'' +
                '}';
    }
}
