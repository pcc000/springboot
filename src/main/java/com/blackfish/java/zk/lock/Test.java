//package com.blackfish.java.zk.lock;
//
///**
// * @Auther: chengchengpeng
// * @Date: 2019/5/29 17:02
// * @Description:
// */
//public class Test {
//
//    static int n = 500;
//
//    public static void secskill() {
//        System.out.println(--n);
//    }
//
//    public static void main(String[] args) {
//
//        Runnable runnable = new Runnable() {
//            public void run() {
//                ZkDistributeLock lock = null;
//                try {
//                    lock = new ZkDistributeLock("127.0.0.1:2181", "test1");
//                    lock.lock();
//                    secskill();
//                    System.out.println(Thread.currentThread().getName() + "正在运行");
//                } finally {
//                    if (lock != null) {
//                        lock.unlock();
//                    }
//                }
//            }
//        };
//
//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(runnable);
//            t.start();
//        }
//    }
//}
