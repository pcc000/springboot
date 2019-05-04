package com.blackfish.java.design.singleton;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/29 14:25
 * @Description:
 *
 * 方式跟饿汉式方式采用的机制类似，但又有不同。
 * 两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
 * 不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，
 * 而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
 */
public class InnerClassSingleton {
    public static class SingletonInstance{
        private static final InnerClassSingleton singleton = new InnerClassSingleton();
    }
    public static InnerClassSingleton getInstance(){
        return SingletonInstance.singleton;
    }
}
