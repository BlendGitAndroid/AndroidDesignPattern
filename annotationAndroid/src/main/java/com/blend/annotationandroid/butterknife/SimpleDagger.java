package com.blend.annotationandroid.butterknife;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.blend.annotation.butterknife.adapter.InjectAdapter;
import com.blend.annotation.butterknife.adapter.NullAdapter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public final class SimpleDagger {


    /**
     *
     */
    public static final String SUFFIX = "$InjectAdapter";
    /**
     *
     */
    static Map<Class<?>, InjectAdapter<?>> sInjectCache = new HashMap<Class<?>, InjectAdapter<?>>();

    /**
     * @param activity
     */
    public static void inject(Activity activity) {
        InjectAdapter<Activity> adapter = getViewAdapter(activity.getClass());
        adapter.injects(activity);
    }

    /**
     * @param fragment
     */
    public static void inject(Fragment fragment, View rootView) {
        InjectAdapter<Fragment> adapter = getViewAdapter(fragment.getClass());
        if (fuckTheFragment(fragment, rootView)) {
            adapter.injects(fragment);
        }
    }

    /**
     * 到Fragment 中找到mView字段,然后设置rootView给mView
     *
     * @param fragment
     * @param rootView
     * @return
     */
    private static boolean fuckTheFragment(Fragment fragment, View rootView) {
        try {
            Class<?> v4fragmentClass = fragment.getClass();
            while (v4fragmentClass != Object.class
                    && !v4fragmentClass.equals(Fragment.class)) {
                v4fragmentClass = v4fragmentClass.getSuperclass();
            }
            Field rootViewField = v4fragmentClass.getDeclaredField("mView");
            rootViewField.setAccessible(true);
            rootViewField.set(fragment, rootView);
            Log.e("", "### getView " + fragment.getView());
            return true;
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * @param view
     */
    public static void inject(View view) {

    }

    @SuppressWarnings({
            "unchecked", "rawtypes"
    })
    private static <T> InjectAdapter<T> getViewAdapter(Class<?> clazz) {
        InjectAdapter<?> adapter = sInjectCache.get(clazz);
        if (adapter == null) {
            String adapterClassName = clazz.getName() + SUFFIX;
            try {
                Class<?> adapterClass = Class.forName(adapterClassName);
                adapter = (InjectAdapter<?>) adapterClass.newInstance();
                sInjectCache.put(adapterClass, adapter);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Log.e("", "### find adapter : " + adapter);

        return adapter == null ? new NullAdapter() : (InjectAdapter<T>) adapter;
    }
}
