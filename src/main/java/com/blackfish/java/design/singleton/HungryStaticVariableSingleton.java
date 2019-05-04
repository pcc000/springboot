package com.blackfish.java.design.singleton;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/29 13:58
 * @Description:
 */
public class HungryStaticVariableSingleton {
    public final static HungryStaticVariableSingleton singleton = new HungryStaticVariableSingleton();
    public HungryStaticVariableSingleton() {
    }
    public static HungryStaticVariableSingleton getSingleton(){
        return singleton;
    }
}
