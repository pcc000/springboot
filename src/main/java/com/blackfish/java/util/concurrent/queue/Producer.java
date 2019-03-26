package com.blackfish.java.util.concurrent.queue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/26 14:33
 * @Description:
 */
public class Producer implements Runnable {


    private BlockingQueue blockingDeque = null;

    public Producer(BlockingQueue blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    public void run() {
        try{
            blockingDeque.put("1");
            Thread.sleep(1000);
            blockingDeque.put("2");
            Thread.sleep(1000);
            blockingDeque.put("3");
        }catch(Exception e){
            e.printStackTrace();;
        }
    }
}
