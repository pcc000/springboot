package com.blackfish.java.util.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/15 11:31
 * @Description:
 */
public class Work implements Runnable {

    private int num;

    private Semaphore semaphore;

    public Work(int num,Semaphore semaphore) {
        this.semaphore = semaphore;
        this.num = num;
    }

    @Override
    public void run() {
        try{
            semaphore.acquire();
            System.out.println("工人"+this.num+"占用一台生成机器");
            Thread.sleep(200);
            System.out.println("工人"+this.num+"释放一台生成机器");
            semaphore.release();
        }catch(Exception e){

        }
    }
}
