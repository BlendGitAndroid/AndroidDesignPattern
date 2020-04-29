package com.blend.androiddesignpattern.o_visitor.butterknife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.blend.androiddesignpattern.R;
import com.blend.annotation.butterknife.anno.ViewInjector;
import com.blend.annotationandroid.butterknife.SimpleDagger;

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
