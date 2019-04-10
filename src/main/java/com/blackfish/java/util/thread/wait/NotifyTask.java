package com.blackfish.java.util.thread.wait;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/10 13:58
 * @Description:
 */
public class NotifyTask implements Runnable {

    private Object o;

    public NotifyTask(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        synchronized (o){
            System.out.println("notify before");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            o.notify();
            System.out.println("notify after");
        }
    }
}
