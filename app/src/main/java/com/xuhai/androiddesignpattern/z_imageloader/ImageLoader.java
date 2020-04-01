package com.xuhai.androiddesignpattern.z_imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ImageLoader {

    private static final String TAG = "ImageLoader";

    // 图片缓存
    ImageCache mImageCache = new MemoryCache();
    // 线程池，线程数量为CPU的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    // UI Handler
    Handler mUiHandler = new Handler(Looper.getMainLooper());

    private void updateImageView(final ImageView imageView, final Bitmap bitmap) {
        mUiHandler.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    //注入缓存实现
    public void setImageCache(ImageCache cache) {
        mImageCache = cache;
    }

    /*
    加载显示图片
     */
    public void displayImage(Context context, String imageUrl, ImageView imageView) {
        Bitmap bitmap = mImageCache.get(imageUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        //图片没有缓存，下载图片
        submitLoadRequest(context, imageUrl, imageView);
    }

    private void submitLoadRequest(Context context, final String imageUrl, final ImageView imageView) {
        Http.getBitmap(imageUrl).observe((LifecycleOwner) context, new Observer<Bitmap>() {
            @Override
            public void onChanged(Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                updateImageView(imageView, bitmap);
                mImageCache.put(imageUrl, bitmap);
            }
        });

    }

}
