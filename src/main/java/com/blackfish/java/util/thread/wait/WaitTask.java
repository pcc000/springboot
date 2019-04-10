package com.blackfish.java.util.thread.wait;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/10 13:50
 * @Description:
 */
public class WaitTask implements Runnable {

    private Object o ;

    public WaitTask(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        synchronized (o){
            System.out.println("wait before:");
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait after");
        }
    }
}
