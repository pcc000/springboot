package com.blackfish.java.design.singleton;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/29 14:10
 * @Description:
 */
public class LazySyncMethodSingleton {
    public static LazySyncMethodSingleton singleton;
    public synchronized static LazySyncMethodSingleton getSingleton(){
        if(null == singleton){
            singleton = new LazySyncMethodSingleton();
        }
        return singleton;
    }
}
