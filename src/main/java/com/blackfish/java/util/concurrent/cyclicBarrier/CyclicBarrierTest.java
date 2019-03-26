package com.blackfish.java.util.concurrent.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/26 16:56
 * @Description: 栅栏
 * java.util.concurrent.CyclicBarrier 类是一种同步机制，它能够对处理一些算法的线程实现同步。换句话讲，它就是一个所有线程必须等待的一个栅栏，直到所有线程都到达这里，然后所有线程才可以继续做其他事情
 */
public class CyclicBarrierTest {

    public static void main(String arg[]){
        Runnable barrier1Action = new Runnable() {
            public void run() {
                System.out.println("BarrierAction 1 executed ");
            }
        };
        //在创建一个 CyclicBarrier 的时候你需要定义有多少线程在被释放之前等待栅栏
        CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);

        CyclicBarrierRunnable cyclicBarrierRunnable1 = new CyclicBarrierRunnable(barrier1);
        CyclicBarrierRunnable cyclicBarrierRunnable2 = new CyclicBarrierRunnable(barrier1);

        new Thread(cyclicBarrierRunnable1).start();
        new Thread(cyclicBarrierRunnable2).start();

    }
}
