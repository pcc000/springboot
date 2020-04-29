package com.blackfish.java;

/**
 * @Auther: shuyiwei
 * @Date: 2020/3/25 12:13
 * @Description:
 */
public class SyncDemo {

    static Object temp = new Object();

    public void test1(){
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName()+" start");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+" end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            new SyncDemo().test1();
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            new SyncDemo().test1();
        }).start();
    }

}
