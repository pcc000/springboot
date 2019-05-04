package com.blackfish.java.design.singleton;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/29 14:19
 * @Description:
 */
public class LazySafeDoubleCheckSingleton {
    private static volatile LazySafeDoubleCheckSingleton singleton;
    public static LazySafeDoubleCheckSingleton getSingleton(){
        if(null != singleton){
            synchronized (LazySafeDoubleCheckSingleton.class){
                if(null != singleton){
                    singleton = new LazySafeDoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
