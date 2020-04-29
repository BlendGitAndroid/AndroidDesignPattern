package com.blend.androiddesignpattern.c_prototype.demo;

public class Test {

    /*
    调用getLoginedUser()获取到的对象是一个拷贝对象，即使对这个拷贝对象进行修改，也不会改变最初已登录的用户对象信息，
    对已登录用户信息的修改只能通过setLoginedUser()这个方法。
     */
    User mUser = LoginSession.getLoginSession().getLoginedUser();

}
