package com.xuhai.androiddesignpattern.c_prototype.demo;

public class LoginSession {

    static LoginSession sLoginSession = null;
    //已登录用户
    private User loginedUser;

    private LoginSession() {
    }

    public static LoginSession getLoginSession() {
        if (sLoginSession == null) {
            sLoginSession = new LoginSession();
        }
        return sLoginSession;
    }

    void setLoginedUser(User user) {
        loginedUser = user;
    }

    public User getLoginedUser() {
        try {
            return (User) loginedUser.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
