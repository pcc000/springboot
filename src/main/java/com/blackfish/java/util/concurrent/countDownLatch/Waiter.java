package com.blackfish.java.util.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/26 16:43
 * @Description:
 */
public class Waiter implements Runnable {

    private CountDownLatch countDownLatch =null;

    public Waiter(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waiter Released");
    }
}
