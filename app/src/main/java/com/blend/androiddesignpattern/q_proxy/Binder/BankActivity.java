package com.blend.androiddesignpattern.q_proxy.Binder;

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

import com.blend.androiddesignpattern.IBankAIDL;
import com.blend.androiddesignpattern.R;
import com.blend.androiddesignpattern.o_visitor.aa_annotation.AnnotationUtil;
import com.blend.androiddesignpattern.o_visitor.aa_annotation.GetViewTo;

/**
 * 在这个例子中，客户端和服务端位于同一个APP的不同的进程，所以共用同一套AIDL文件
 * 要是客户端和服务端不在同一个APP，在服务端定义好AIDL文件后，客户端也需要有与服务端完全相同的AIDL文件，包括包名和使用到的实体类
 * 这样就能够通过AIDL进行客户端和服务端的通信了
 */
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

        //绑定服务端的Service
        bindService(new Intent(this, BankService.class), conn, BIND_AUTO_CREATE);

        openAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    aidlTv.setText(mBankAIDL.openAccount("Blend", "123456"));
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

    //绑定成功后，将服务端返回的Binder对象转换成AIDL接口所属的类型，就可以调用AIDL中的方法了。
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
