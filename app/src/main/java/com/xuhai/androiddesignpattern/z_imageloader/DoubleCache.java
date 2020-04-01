package com.xuhai.androiddesignpattern.z_imageloader;

import android.graphics.Bitmap;

public class DoubleCache implements ImageCache {

    /*
    内存缓存
     */
    ImageCache mMemoryCache = new MemoryCache();
    /*
    磁盘缓存
     */
    ImageCache mDiskCache = new DiskCache();

    /*
    优先使用内存加载，如果没有再使用SD卡缓存
     */
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    /*
    将图片缓存到内存和SD卡中
     */
    @Override
    public void put(String url, Bitmap bitmap) {
        mMemoryCache.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }
}
