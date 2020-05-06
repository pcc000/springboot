package com.blackfish.java.util.thread.futureTask;

import java.util.concurrent.*;

/**
 * @Auther: shuyiwei
 * @Date: 2020/5/6 19:23
 * @Description:
 */
public class Test {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Executor threadPool  = Executors.newFixedThreadPool(10);
        Future<String> result = ((ExecutorService) threadPool).submit(()->{
            return "";
        });
        result.get();
    }

}
