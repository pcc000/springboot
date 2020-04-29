package com.blackfish.java.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: shuyiwei
 * @Date: 2020/4/28 19:54
 * @Description:
 */
public class CounterLock implements Counter {

    Lock lock = new ReentrantLock();
    volatile int  i=0;

    @Override
    public int incr() {
        lock.lock();
        try{
            return i++;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public int descr() {
        lock.lock();
        try{
            return i--;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public int get() {
        return i;
    }
}
