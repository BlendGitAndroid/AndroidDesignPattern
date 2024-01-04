package com.blend.androiddesignpattern.p_mediator;

public class MediatorClient {

    public static void test() {

        // 中介者管理同事类
        MainBoard mediator = new MainBoard();   //中介者

        CDDevice cdDevice = new CDDevice(mediator);     //每一个都知道中介者，这四个都是同事
        CPU cpu = new CPU(mediator);
        GraphicsCard graphicsCard = new GraphicsCard(mediator);
        SoundCard soundCard = new SoundCard(mediator);

        // 中介者设置数据
        mediator.setCDDevice(cdDevice);
        mediator.setCPU(cpu);
        mediator.setGraphicsCard(graphicsCard);
        mediator.setSoundCard(soundCard);

        // 同事播放CD的时候，最终调用的是中介者的方法
        cdDevice.load();
    }

}
