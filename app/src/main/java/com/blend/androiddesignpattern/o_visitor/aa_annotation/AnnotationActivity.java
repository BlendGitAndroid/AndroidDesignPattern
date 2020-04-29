package com.blend.androiddesignpattern.o_visitor.aa_annotation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blend.androiddesignpattern.R;

public class AnnotationActivity extends AppCompatActivity {

    @GetViewTo(R.id.annotationTv)
    private TextView mTextView;

    @GetViewTo(R.id.annotationBtn)
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.annotation_layout);
        AnnotationUtil.getAllAnnotationView(this);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("好");
            }
        });
    }

}
