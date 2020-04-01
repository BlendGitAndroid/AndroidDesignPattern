package com.xuhai.androiddesignpattern.l_memento.Demo2.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.xuhai.androiddesignpattern.l_memento.Demo2.notemgr.Memoto;


@SuppressLint("AppCompatCustomView")
public class NoteEditText extends EditText {


    public NoteEditText(Context context) {
        super(context);
    }

    public NoteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoteEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Memoto createMemoto() {
        Memoto noteMemoto = new Memoto();
        // 存储文本与光标位置
        noteMemoto.text = getText().toString();
        noteMemoto.cursor = getSelectionStart();
        return noteMemoto;
    }

    public void restore(Memoto memoto) {
        setText(memoto.text);
        // 设置光标位置
        setSelection(memoto.cursor);
    }

}
