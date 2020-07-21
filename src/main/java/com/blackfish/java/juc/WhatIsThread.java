package com.blackfish.java.juc;

import java.util.concurrent.*;

/**
 * @Auther: shuyiwei
 * @Date: 2020/7/1 20:10
 * @Description:
 */
public class WhatIsThread {

    private static class T1 extends Thread{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                try {
                    TimeUnit.MICROSECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1");
            }
        }
    }

    private static class R1 implements Runnable{
        @Override
        public void run() {
            System.out.println("R1");
        }
    }

    private static class C1 implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println("C1");
            return "success";
        }
    }


    //一个任务T  由N个子任务构成 每个子任务完成的时长不同  若其中一个子任务失败  所有任务结束 T任务结束

    public static void main(String[] args) throws Exception {
        CompletableFuture futureT = CompletableFuture.supplyAsync(()->{System.out.println("123") ; return "123";}).thenAccept((result)-> System.exit(0));
//        new T1().start();
//        new Thread(new R1()).start();
//
//        FutureTask<String> str = new FutureTask<>(new C1());
//        new Thread(str).start();
//        System.out.println(str.get());

        Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main");
        }
    }
}
