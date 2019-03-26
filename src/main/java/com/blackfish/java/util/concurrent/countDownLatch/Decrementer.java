package com.blackfish.java.util.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/26 16:41
 * @Description:
 */
public class Decrementer implements Runnable {

    CountDownLatch countDownLatch = null;

    public Decrementer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("first");
            this.countDownLatch.countDown();

            Thread.sleep(1000);
            System.out.println("second");
            this.countDownLatch.countDown();

            Thread.sleep(1000);
            System.out.println("last");
            this.countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
