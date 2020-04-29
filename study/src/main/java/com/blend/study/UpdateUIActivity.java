package com.blend.study;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class UpdateUIActivity extends AppCompatActivity {

    /**
     * 只能在UI线程更新UI吗?
     * <p>
     * 博客地址：
     * https://mp.weixin.qq.com/s?__biz=MzAxMTI4MTkwNQ==&mid=2650830411&idx=1&sn=f516e0e3260a984fdcf06b536a398a64&chksm=80b7a2d5b7c02bc3e41449ce02a2813da5d826aae7d8ec25c3bfc44ebfaf0c0affe151118fe9&scene=126&sessionid=1587345644&key=c70cad9466e6a572b7285b97c9e249a42081f1377790b022b056ee76d34f14f799d50b018e59896adc60837f5ab46d478e6d6e3a43e3136e60741d42d405f6c2526a4568866a1b487c6a658513f9daf5&ascene=1&uin=MTMyNDY1NDcwMQ%3D%3D&devicetype=Windows+10&version=62080079&lang=zh_CN&exportkey=AaVgszH%2FreVDjewb%2F62pHRk%3D&pass_ticket=xiUjB66bZpfWhNDloby60XIiop%2BCK9sqO7j42wZKvkKpfzFdDal8zWxS3V760Pzg
     */

    private Button mButton;
    private TextView mTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_ui_main);
        mButton = findViewById(R.id.updateBtn);
        mTextView = findViewById(R.id.updateTv);
        changeUI();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestAQuestion();
            }
        });
    }

    /*
    这种改变UI的方式，就是ViewRootImpl还没有被创建，不会调用ViewRootImpl的checkThread()方法，所以不会有异常
    */
    private void changeUI() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mTextView.setText("已经改变了");
            }
        }).start();
    }

    private void requestAQuestion() {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 模拟服务器请求，返回问题
                String title = "鸿洋帅气吗？";
                showQuestionInDialog(title);
            }
        }.start();
    }

    /*
        增加Looper，否则会报出：Can't create handler inside thread Thread[Thread-2,5,main] that has not
        called Looper.prepare()
        这是因为在子线程中需要处理消息循环，需要创建Handler，而Looper是属于某个线程的，消息队列又存储在Looper中，创建Handler
        时候需要判断该线程的Looper是否被创建。
     */
    private void showQuestionInDialog(String title) {
        Looper.prepare();
        QuestionDialog questionDialog = new QuestionDialog(this);
        questionDialog.show(title);
        Looper.loop();
    }
}
