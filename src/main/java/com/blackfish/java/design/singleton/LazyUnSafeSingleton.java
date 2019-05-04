package com.blackfish.java.design.singleton;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/29 14:03
 * @Description:
 */
public class LazyUnSafeSingleton {
    private static LazyUnSafeSingleton singleton;
    public static LazyUnSafeSingleton getSingleton(){
        if(null == singleton){
            singleton = new LazyUnSafeSingleton();
        }
        return singleton;
    }
}
