package com.blackfish.java.util.concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/27 20:47
 * @Description:
 */
public class AtomicTest {

    public static void main(String arg[]) throws Exception{
        ExecutorService   executor  = Executors.newFixedThreadPool(100);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        executor.execute(new AtomicIntegerTask(atomicInteger));
        executor.execute(new AtomicIntegerTask(atomicInteger));
        executor.execute(new AtomicIntegerTask(atomicInteger));
        executor.shutdown();
        Thread.sleep(1000);
        System.out.println(atomicInteger.get());
    }

}
