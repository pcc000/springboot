package com.blackfish.java.util.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/26 16:44
 * @Description: 闭锁
 * ava.util.concurrent.CountDownLatch 是一个并发构造，它允许一个或多个线程等待一系列指定操作的完成。
 * CountDownLatch 以一个给定的数量初始化。countDown() 每被调用一次，这一数量就减一。
 * 通过调用 await() 方法之一，线程可以阻塞等待这一数量到达零。
 */
public class CountDownLatchTest {

    public static void main(String arg[]) throws  Exception{
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Waiter waiter = new Waiter(countDownLatch);
        Decrementer decrementer = new Decrementer(countDownLatch);
        new Thread(waiter).start();
        new Thread(decrementer).start();
//        Thread.sleep(5000);

    }
}
