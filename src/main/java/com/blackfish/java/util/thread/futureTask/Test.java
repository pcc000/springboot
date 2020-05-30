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
        Future<Integer> result = ((ExecutorService) threadPool).submit(()->{
            return 1;
        });

        Integer str = result.get();
        System.out.println(str);
    }

}
