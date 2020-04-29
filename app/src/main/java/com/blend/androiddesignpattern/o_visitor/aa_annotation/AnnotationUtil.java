package com.blend.androiddesignpattern.o_visitor.aa_annotation;

import android.app.Activity;

import java.lang.reflect.Field;

public class AnnotationUtil {

    public static void getAllAnnotationView(Activity activity) {
        Field[] fields = activity.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotations() != null) {
                if (field.isAnnotationPresent(GetViewTo.class)) {
                    field.setAccessible(true);
                    GetViewTo getViewTo = field.getAnnotation(GetViewTo.class);
                    try {
                        field.set(activity, activity.findViewById(getViewTo.value()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
