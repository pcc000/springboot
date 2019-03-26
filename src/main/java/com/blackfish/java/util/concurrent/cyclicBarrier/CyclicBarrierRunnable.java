package com.blackfish.java.util.concurrent.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/26 16:57
 * @Description:
 */
public class CyclicBarrierRunnable implements Runnable {

    CyclicBarrier cyclicBarrier = null;

    public CyclicBarrierRunnable(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() +
                    " waiting at barrier 1");
            this.cyclicBarrier.await();

            System.out.println(Thread.currentThread().getName() +
                    " done!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
