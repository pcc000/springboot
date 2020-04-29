package com.blackfish.java.counter;

/**
 * @Auther: shuyiwei
 * @Date: 2020/4/28 19:52
 * @Description:
 */
public class CounterSync implements Counter {

    volatile  int i=0;

    @Override
    public synchronized int incr() {
        return i++;
    }

    @Override
    public synchronized int descr() {
        return i--;
    }

    @Override
    public synchronized int get() {
        return i;
    }
}
