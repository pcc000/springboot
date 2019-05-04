package com.blackfish.java.design.singleton;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/29 14:16
 * @Description:
 */
public class LazySyncBlockSingleton {
    private static LazySyncBlockSingleton singleton;
    public static LazySyncBlockSingleton getSingleton(){
        if(null != singleton){
            synchronized (LazySyncBlockSingleton.class){
                singleton = new LazySyncBlockSingleton();
            }
        }
        return singleton;
    }
}
