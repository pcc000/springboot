package com.blackfish.java.design.singleton;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/29 14:00
 * @Description:
 */
public class HungryStaticBlockSingleton {
    public static HungryStaticBlockSingleton singleton;
    static{
        singleton = new HungryStaticBlockSingleton();
    }
    public static HungryStaticBlockSingleton getSingleton(){
        return singleton;
    }
}
