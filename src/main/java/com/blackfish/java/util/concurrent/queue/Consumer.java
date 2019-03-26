package com.blackfish.java.util.concurrent.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/26 15:09
 * @Description:
 */
public class Consumer implements Runnable {

    private BlockingQueue blockingQueue = null;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try{
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
