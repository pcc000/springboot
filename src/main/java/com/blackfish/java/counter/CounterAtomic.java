package com.blackfish.java.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: shuyiwei
 * @Date: 2020/4/28 20:00
 * @Description:
 */
public class CounterAtomic  implements Counter{

    AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public int incr() {
        return atomicInteger.incrementAndGet();
    }

    @Override
    public int descr() {
        return atomicInteger.decrementAndGet();
    }

    @Override
    public int get() {
        return atomicInteger.get();
    }
}
