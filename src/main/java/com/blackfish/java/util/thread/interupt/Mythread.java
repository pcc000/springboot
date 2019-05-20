package com.blackfish.java.util.thread.interupt;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/17 23:28
 * @Description:
 */
public class Mythread extends Thread {

    @Override
    public void run() {
        super.run();
        for(int i=0;i<5000;i++){
            System.out.println("i="+i);
        }
    }
}
