package com.xuhai.androiddesignpattern.q_proxy.Binder;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xuhai.androiddesignpattern.IBankAIDL;
import com.xuhai.androiddesignpattern.R;
import com.xuhai.androiddesignpattern.o_visitor.aa_annotation.AnnotationUtil;
import com.xuhai.androiddesignpattern.o_visitor.aa_annotation.GetViewTo;


public class BankActivity extends AppCompatActivity {

    @GetViewTo(R.id.aidlTv)
    private TextView aidlTv;

    @GetViewTo(R.id.openAccountBtn)
    private Button openAccountBtn;

    @GetViewTo(R.id.saveMoneyBtn)
    private Button saveMoneyBtn;

    @GetViewTo(R.id.takeMoneyBtn)
    private Button takeMoneyBtn;

    @GetViewTo(R.id.closeCountBtn)
    private Button closeCountBtn;

    private IBankAIDL mBankAIDL;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aidl_layout);
        AnnotationUtil.getAllAnnotationView(this);
        bindService(new Intent(this, BankService.class), conn, BIND_AUTO_CREATE);

        openAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    aidlTv.setText(mBankAIDL.openAccount("XuHai", "123456"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        saveMoneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    aidlTv.setText(mBankAIDL.saveMoney(1000, "abc123"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        takeMoneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    aidlTv.setText(mBankAIDL.takeMoney(1000, "abc123", "123456"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        closeCountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    aidlTv.setText(mBankAIDL.closeCount("abc123", "123456"));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mBankAIDL = IBankAIDL.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }
}
