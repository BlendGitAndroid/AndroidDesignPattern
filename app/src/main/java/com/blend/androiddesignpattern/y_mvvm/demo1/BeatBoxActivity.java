package com.blend.androiddesignpattern.y_mvvm.demo1;

import androidx.fragment.app.Fragment;

public class BeatBoxActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return BeatBoxFragment.newInstance();
    }
}
