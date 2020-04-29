package com.blend.annotationandroid.butterknife;

import android.app.Activity;
import android.view.View;

import androidx.fragment.app.Fragment;

@SuppressWarnings("unchecked")
public final class ViewFinder {

    public static <T extends View> T findViewById(Activity act, int id) {
        return (T) act.findViewById(id);
    }

    public static <T extends View> T findViewById(View rootView, int id) {
        return (T) rootView.findViewById(id);
    }

    public static <T extends View> T findViewById(Fragment fragment, int id) {
        return findViewById(fragment.getView(), id);
    }

}
