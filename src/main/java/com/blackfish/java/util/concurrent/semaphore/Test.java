package com.blackfish.java.util.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/15 11:34
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for(int i=0;i<10;i++){
            new Thread(new Work(i,semaphore)).start();
        }
    }
}
