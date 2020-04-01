package com.xuhai.androiddesignpattern.o_visitor.aa_annotation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xuhai.androiddesignpattern.R;

import java.lang.reflect.Field;

public class AnnotationActivity extends AppCompatActivity {

    @GetViewTo(R.id.annotationTv)
    private TextView mTextView;

    @GetViewTo(R.id.annotationBtn)
    private Button mButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.annotation_layout);
        getAllAnnotationView();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("好");
            }
        });
    }

    private void getAllAnnotationView() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotations() != null) {
                if (field.isAnnotationPresent(GetViewTo.class)) {
                    field.setAccessible(true);
                    GetViewTo getViewTo = field.getAnnotation(GetViewTo.class);
                    try {
                        field.set(this, findViewById(getViewTo.value()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
