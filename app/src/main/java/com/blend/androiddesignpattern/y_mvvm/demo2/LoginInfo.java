package com.blend.androiddesignpattern.y_mvvm.demo2;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class LoginInfo extends BaseObservable {

    @NonNull
    private String mUser;

    @NonNull
    private String mPassword;

    public LoginInfo(@NonNull String user, @NonNull String password) {
        mUser = user;
        mPassword = password;
    }

    @NonNull
    @Bindable
    public String getUser() {
        return mUser;
    }

    public void setUser(@NonNull String user) {
        mUser = user;
        // notifyPropertyChanged();
    }

    @NonNull
    @Bindable
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(@NonNull String password) {
        mPassword = password;
        // notifyPropertyChanged();
    }
}
