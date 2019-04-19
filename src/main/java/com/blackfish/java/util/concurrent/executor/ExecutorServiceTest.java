package com.blackfish.java.util.concurrent.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/26 17:31
 * @Description:
 */
public class ExecutorServiceTest {

    public static void main(String arg[]){
        Executor e1 = Executors.newCachedThreadPool();
        Executor e2 = Executors.newFixedThreadPool(10);
        Executor e3 = Executors.newSingleThreadExecutor();
        Executor e4 = Executors.newScheduledThreadPool(10);
    }
}
