package com.blend.androiddesignpattern.p_mediator;

public class MainBoard extends Mediator {

    private CDDevice mCDDevice; //光驱设备
    private CPU mCPU;           //CPU
    private SoundCard mSoundCard;   //声卡设备
    private GraphicsCard mGraphicsCard; //显卡设备

    @Override
    public void changed(Colleague colleague) {
        if (colleague == mCDDevice) {
            handleCD((CDDevice) colleague);
        } else if (colleague == mCPU) {
            handleCPU((CPU) colleague);
        }
    }

    private void handleCPU(CPU cpu) {
        mSoundCard.soundPlay(cpu.getDataSound());
        mGraphicsCard.videoPlay(cpu.getDataVideo());
    }

    private void handleCD(CDDevice cdDevice) {
        mCPU.decodeData(cdDevice.getData());
    }

    public void setCDDevice(CDDevice CDDevice) {
        mCDDevice = CDDevice;
    }

    public void setCPU(CPU CPU) {
        mCPU = CPU;
    }

    public void setSoundCard(SoundCard soundCard) {
        mSoundCard = soundCard;
    }

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        mGraphicsCard = graphicsCard;
    }
}
