package com.blackfish.java.counter;

/**
 * @Auther: shuyiwei
 * @Date: 2020/4/28 19:30
 * @Description:
 */
public class CounterBasic implements Counter {

    volatile  int i=0;

    @Override
    public int incr() {
        return i++;
    }

    @Override
    public int descr() {
        return i--;
    }

    @Override
    public int get() {
        return i;
    }
}
