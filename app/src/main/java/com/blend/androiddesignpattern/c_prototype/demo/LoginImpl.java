package com.blend.androiddesignpattern.c_prototype.demo;

import static com.blend.androiddesignpattern.c_prototype.demo.LoginSession.getLoginSession;

public class LoginImpl implements Login {
    @Override
    public void login() {
        //登录服务器获取到的信息
        User loginedUser = new User();
        loginedUser.age = 26;
        loginedUser.name = "徐海";
        loginedUser.address = new Address("杭州市", "西湖区", "塘苗路");
        getLoginSession().setLoginedUser(loginedUser);
    }
}
