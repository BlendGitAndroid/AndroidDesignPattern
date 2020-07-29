package com.blend.androiddesignpattern.y_mvvm.demo2;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

public class LoginModel {

    private static final String DEF_USER = "Blend";
    private static final String DEF_PASSWORD = "abc.123456";

    public final LoginInfo mInfo = new LoginInfo("", "");

    private final OnLoginListener mListener;

    public LoginModel(OnLoginListener listener) {
        mListener = listener;
    }

    public TextWatcher getUserTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mInfo.setUser(s.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mInfo.setPassword(s.toString());
            }
        };
    }

    public void onLoginClick(View view) {
        if (mInfo.getUser().equals(DEF_USER) && mInfo.getPassword().equals(DEF_PASSWORD)) {
            mListener.onLoginSuccess();
        } else {
            mListener.onLoginFail();
        }
    }

    public interface OnLoginListener {
        void onLoginSuccess();

        void onLoginFail();
    }
}
