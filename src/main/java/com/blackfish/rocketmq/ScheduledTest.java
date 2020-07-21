package com.blackfish.rocketmq;

import org.apache.rocketmq.client.impl.consumer.ProcessQueue;
import org.apache.rocketmq.common.ThreadFactoryImpl;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: shuyiwei
 * @Date: 2020/7/15 17:16
 * @Description:
 */
public class ScheduledTest {

    private final ScheduledExecutorService scheduledExecutorService;

    public ScheduledTest() {
        this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryImpl("test"));;
    }


    public static void main(String[] args) {
        ScheduledTest test = new ScheduledTest();
        test.scheduledExecutorService.scheduleAtFixedRate(()->{
            System.out.println(System.currentTimeMillis()+" test");
        },1000L, 122, TimeUnit.MILLISECONDS);
    }
}
