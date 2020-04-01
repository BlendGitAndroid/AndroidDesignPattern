package com.xuhai.androiddesignpattern.l_memento.Demo1;

import android.util.Log;

public class CallOfDuty {

    protected static final String TAG = "CallOfDuty";

    private int mCheckPoint = 1;    //关数
    private int mLeftValue = 100;   //生命值
    private String mWeapon = "沙漠之鹰";

    //玩游戏
    public void play() {
        Log.e(TAG, "玩游戏：第" + mCheckPoint + "关，奋力杀敌中");
        mLeftValue -= 10;
        Log.e(TAG, "进度升级！");
        mCheckPoint++;
        Log.e(TAG, "到达第" + mCheckPoint + "关");
    }

    //退出游戏
    public void quit() {
        Log.e(TAG, "退出前的游戏属性：" + this.toString());
        Log.e(TAG, "退出游戏");
    }

    //创建备忘录
    public Memoto createMemoto() {
        Memoto memoto = new Memoto();
        memoto.mCheckPoint = mCheckPoint;
        memoto.mLeftValue = mLeftValue;
        memoto.mWeapon = mWeapon;
        return memoto;
    }

    //恢复游戏
    public void restore(Memoto memoto) {
        this.mCheckPoint = memoto.mCheckPoint;
        this.mLeftValue = memoto.mLeftValue;
        this.mWeapon = memoto.mWeapon;
        Log.e(TAG, "恢复后的游戏属性: " + this.toString());
    }

    @Override
    public String toString() {
        return "CallOfDuty{" +
                "mCheckPoint=" + mCheckPoint +
                ", mLeftValue=" + mLeftValue +
                ", mWeapon='" + mWeapon + '\'' +
                '}';
    }
}
