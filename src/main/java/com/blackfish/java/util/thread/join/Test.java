package com.blackfish.java.util.thread.join;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/10 14:44
 * @Description:
 * 用 join 方式实现问题如下，在代码中 main 线程被阻塞直到 thread1，thread2，thread3 执行完，
 * 主线程才会顺序的执行thread4，即boss先要等3个worker工作结束才check工作
 */
public class Test {

    public static void main(String[] args) {
        Work work1 = new Work("work1");
        Work work2 = new Work("work2");
        Work work3 = new Work("work3");
        Boss boss = new Boss("boss");

        Thread t1 = new Thread(work1);
        Thread t2 = new Thread(work2);
        Thread t3 = new Thread(work3);
        Thread t4 = new Thread(boss);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t4.start();
    }
}
