package com.blend.androiddesignpattern.p_mediator;

public class MediatorClient {

    public static void test() {
        MainBoard mediator = new MainBoard();   //中介者

        CDDevice cdDevice = new CDDevice(mediator);     //这四个都是同事
        CPU cpu = new CPU(mediator);
        GraphicsCard graphicsCard = new GraphicsCard(mediator);
        SoundCard soundCard = new SoundCard(mediator);

        mediator.setCDDevice(cdDevice);
        mediator.setCPU(cpu);
        mediator.setGraphicsCard(graphicsCard);
        mediator.setSoundCard(soundCard);

        cdDevice.load();
    }

}
