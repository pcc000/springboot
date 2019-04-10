package com.blackfish.java.util.thread.wait;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/10 13:52
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        WaitTask a = new WaitTask(lock);
        NotifyTask notifyTask = new NotifyTask(lock);
        Thread thread = new Thread(a);
        thread.start();
        Thread.sleep(1000);
        Thread thread2 = new Thread(notifyTask);
        thread2.start();
    }
}
