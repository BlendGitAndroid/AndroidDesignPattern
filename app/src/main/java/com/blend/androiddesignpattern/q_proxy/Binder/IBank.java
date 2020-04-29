package com.blend.androiddesignpattern.q_proxy.Binder;

public interface IBank {

    /**
     * 开户
     *
     * @param name     户主名字
     * @param password 密码
     * @return 开户信息
     */
    String openAccount(String name, String password);

    /**
     * 存钱
     *
     * @param money   金额
     * @param account 账户
     * @return 存钱信息
     */
    String saveMoney(int money, String account);

    /**
     * 取钱
     *
     * @param money    金额
     * @param account  账户
     * @param password 密码
     * @return 账户信息
     */
    String takeMoney(int money, String account, String password);

    /**
     * 销户
     *
     * @param account  账户
     * @param password 密码
     * @return 销户信息
     */
    String closeCount(String account, String password);

}
