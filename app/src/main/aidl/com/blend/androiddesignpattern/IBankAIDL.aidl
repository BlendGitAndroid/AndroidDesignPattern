// IBankAIDL.aidl
package com.blend.androiddesignpattern;

// Declare any non-default types here with import statements

interface IBankAIDL {

        /*
         * .aidl文件
         *暴露给客户端的接口，在AIDL文件中声明，最后在Service中实现这个AIDL接口。
         *如果在AIDL中用到了自定义的Parcelable对象，那么必须新建一个和它同名的AIDL文件，并在其中声明它为Parcelable类型。
        *比如：用到了Book这个类，必须要创建Bool.aidl，然后在里面添加(parcelable Book;)
        */

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
