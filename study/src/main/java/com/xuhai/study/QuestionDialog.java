package com.xuhai.study;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;


public class QuestionDialog extends Dialog {
    private TextView mTvTitle;
    private Button mBtnYes;
    private Button mBtnNo;

    /*
     这里的Handler传递了Looper参数，在不传递Loop参数给Handler构造函数的情况下，更新UI的Handler必须在UI线程中创建，这样
     默认传的Looper就是主线程的Looper。
     */
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public QuestionDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_question);

        mTvTitle = findViewById(R.id.tv_title);
        mBtnYes = findViewById(R.id.btn_yes);
        mBtnNo = findViewById(R.id.btn_no);

        mBtnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = mTvTitle.getText().toString();
                mTvTitle.setText(s + "?");

                boolean uiThread = Looper.myLooper() == Looper.getMainLooper();
                Toast.makeText(getContext(), "UI thread = " + uiThread, Toast.LENGTH_SHORT).show();
                printViewParentHierarchy(mTvTitle, 0);
            }
        });

        /*
         *点击“否”，APP崩溃了，错误是Only the original thread that created a view hierarchy can touch its views.
         *那为什么点击“是”的时候，没有崩溃呢?
         *
         * 因为：ViewRootImpl构造的时候，赋值的Thread就是当前的Thread对象，也就是说，你ViewRootImpl在哪个线程创建的，
         * 你后续的UI更新就需要在哪个线程执行，跟是不是UI线程毫无关系。
         *
         * 这也就说明了：
         * Dialog的ViewRootImpl，其实是在执行show()方法的时候创建的，而我们的Dialog的show放在子线程里面，所以导致后续View更新，
         * 执行到ViewRootImpl#checkThread的时候，都在子线程才可以。
         *
         */
        mBtnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mTvTitle.setText("测试");
                    }
                });
            }
        });
    }

    public void show(String title) {
        mTvTitle.setText(title);
        show();
    }

    /*
     * ViewRootImpl怎么和View关联起来的？
     *
     * 绘制的时候，调用View#requestLayout()，requestLayout()再调用mParent.requestLayout()，这个mParent就是ViewParent，
     * 而ViewRootImpl实现了ViewParent接口，真正的判断是在ViewRootImpl#requestLayout()中。
     *
     * 打印下ViewParent体系
     *
     * 结果：
     *
     * com.xuhai.androiddesignpattern D/lmj: AppCompatTextView
     * com.xuhai.androiddesignpattern D/lmj: 	RelativeLayout
     * com.xuhai.androiddesignpattern D/lmj: 		FrameLayout
     * com.xuhai.androiddesignpattern D/lmj: 			FrameLayout
     * com.xuhai.androiddesignpattern D/lmj: 				LinearLayout
     * com.xuhai.androiddesignpattern D/lmj: 					DecorView
     * com.xuhai.androiddesignpattern D/lmj: 						ViewRootImpl
     */
    private void printViewParentHierarchy(Object view, int level) {
        if (view == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        sb.append(view.getClass().getSimpleName());
        Log.d("lmj", sb.toString());

        if (view instanceof View) {
            printViewParentHierarchy(((View) view).getParent(), level + 1);
        }

    }
}
