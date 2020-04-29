package com.blend.androiddesignpattern.a_singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonManager {

    private static Map<String, Object> objectMap = new HashMap<>();

    private SingletonManager() {
    }

    /*
    将多种单例注入到一个统一的管理类中
     */
    public static void registerService(String key, Object instance) {
        if (!objectMap.containsKey(key)) {
            objectMap.put(key, instance);
        }
    }

    /*
    根据key获取到相应的类型对象
     */
    public static Object getService(String key) {
        return objectMap.get(key);
    }

}
