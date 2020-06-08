package com.blend.androiddesignpattern.q_proxy.Binder;

import com.blend.androiddesignpattern.IBankAIDL;

import java.util.UUID;

/**
 * 服务端的代码，在这里实现AIDL中定义的接口
 */
public class BankBinder extends IBankAIDL.Stub {

    @Override
    public String openAccount(String name, String password) {
        return name + "开户成功！账号为：" + UUID.randomUUID().toString();
    }

    @Override
    public String saveMoney(int money, String account) {
        return "账户：" + account + "存入" + money + "单位：人命币";
    }

    @Override
    public String takeMoney(int money, String account, String password) {
        return "账户：" + account + "支取" + money + "单位：人命币";
    }

    @Override
    public String closeCount(String account, String password) {
        return account + "销户成功！";
    }
}
