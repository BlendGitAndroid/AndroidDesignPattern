package com.xuhai.annotation.butterknife.util;

import java.io.Closeable;
import java.io.IOException;

public class IOUtil {
    public static void closeQuitly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
