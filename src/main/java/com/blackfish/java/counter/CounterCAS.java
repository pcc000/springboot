package com.blackfish.java.counter;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Auther: shuyiwei
 * @Date: 2020/4/28 21:04
 * @Description:
 */
public class CounterCAS implements Counter {

    static Unsafe unsafe = null;

    private  static long valueOffset=0 ;

    volatile int i=0;

    static {
        try{
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe)theUnsafe.get(null);
            valueOffset = unsafe.objectFieldOffset(CounterCAS.class.getDeclaredField("i"));
        }catch (Exception e){

        }
    }

    @Override
    public int incr() {
        for(;;){
            int current =i;
            int update = i+1;
            if(unsafe.compareAndSwapInt(this,valueOffset,current,update)){
                return update;
            }
        }
    }

    @Override
    public int descr() {
        for(;;){
            int current =i;
            int update = i-1;
            if(unsafe.compareAndSwapInt(this,valueOffset,current,update)){
                return update;
            }
        }
    }

    @Override
    public int get() {
        return i;
    }
}
