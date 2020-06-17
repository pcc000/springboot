//package com.blackfish.java.suanfa.thread.alternatePrint;
//
//import oracle.jvm.hotspot.jfr.ThreadStates;
//import sun.misc.Unsafe;
//
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.LockSupport;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @Auther: shuyiwei
// * @Date: 2020/5/7 20:20
// * @Description:
// */
//public class Foo {
//
//     void one() { System.out.println("one"); }
//     void two() { System.out.println("two"); }
//     void three() { System.out.println("three");}
//
//
//    public Foo() {
//
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//
//        // printFirst.run() outputs "first". Do not change or remove this line.
//        printFirst.run();
//    }
//
//
//    public void second(Runnable printSecond) throws InterruptedException {
//
//        // printSecond.run() outputs "second". Do not change or remove this line.
//        printSecond.run();
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//
//        // printThird.run() outputs "third". Do not change or remove this line.
//        printThird.run();
//    }
//
//    public static void main(String[] args) {
//        Foo f = new Foo();
//
//        Thread.State
//        Lock lock = new ReentrantLock();
//        Condition c1 = lock.newCondition();
//        Condition c2 = lock.newCondition();
//        Condition c3 = lock.newCondition();
//
//        AtomicInteger first = new AtomicInteger(0);
//        AtomicInteger second = new AtomicInteger(0);
//
//        new Thread(()->{
////            f.one();
////            first.incrementAndGet();
//            try {
//                lock.lock();
//                f.one();
//                c2.signal();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        }).start();
//
//        new Thread(()->{
////           while(first.get()!=1){
////
////           }
////           f.two();
////           second.incrementAndGet();
//            try {
//                lock.lock();
//                f.two();
//                c3.signal();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        }).start();
//
//
//        new Thread(()->{
////            while (second.get()!=1){
////
////            }
////            f.three();
//            try {
//                lock.lock();
//                c3.await();
//                f.three();
//                c1.signal();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//        }).start();
//    }
//
//}
