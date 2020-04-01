package com.xuhai.androiddesignpattern.o_visitor.butterknife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.xuhai.androiddesignpattern.R;
import com.xuhai.annotation.butterknife.anno.ViewInjector;
import com.xuhai.annotationandroid.butterknife.SimpleDagger;

public class DemoActivity extends AppCompatActivity {

    @ViewInjector(R.id.butterKnifeTv)
    private TextView mTextView;

    @ViewInjector(R.id.butterKnifeBtn)
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        SimpleDagger.inject(this);
    }
}
