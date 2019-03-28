package com.blackfish.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/27 20:50
 * @Description:
 */
public class AtomicIntegerTask implements Runnable {

    private AtomicInteger automicInteger;

    public AtomicIntegerTask(AtomicInteger automicInteger) {
        this.automicInteger = automicInteger;
    }

    @Override
    public void run() {
        int cnt = 10;

        while (cnt-- > 0) {
            automicInteger.incrementAndGet();
        }
    }
}
