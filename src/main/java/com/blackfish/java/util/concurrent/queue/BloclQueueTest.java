package com.blackfish.java.util.concurrent.queue;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/26 15:11
 * @Description:
 */
public class BloclQueueTest {

    public static void main(String arg[]){

        Hashtable map = new Hashtable<>();
        map.put(null,"234");
        System.out.println(map.get(null));

        HashMap map1 = new HashMap();
        map1.put(null,"234");
        System.out.println(map1.get(null));


        BlockingQueue blockingQueue = new ArrayBlockingQueue(1024);

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
