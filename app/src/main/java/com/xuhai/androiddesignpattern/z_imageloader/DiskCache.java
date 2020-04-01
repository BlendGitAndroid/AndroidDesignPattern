package com.xuhai.androiddesignpattern.z_imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DiskCache implements ImageCache {

    private static final String TAG = "DiskCache";

    private static final String sCacheDir = Environment.getExternalStorageState() + "ImageCache";

    /*
    从SD卡读取数据
     */
    @Override
    public Bitmap get(String url) {
        File file = new File(sCacheDir + url.hashCode());
        if (!file.exists()) {
            return null;
        }
        return BitmapFactory.decodeFile(sCacheDir + url.hashCode());
    }

    /*
    存储到SD卡中
     */
    @Override
    public void put(String url, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(sCacheDir);
            if (!file.exists() && file.isDirectory()) {
                file.mkdirs();
            }
            fileOutputStream = new FileOutputStream(sCacheDir + url.hashCode());
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
