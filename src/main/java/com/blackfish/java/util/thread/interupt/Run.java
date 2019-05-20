package com.blackfish.java.util.thread.interupt;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/17 23:30
 * @Description:
 */
public class Run {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<String,Object>();
        try{
            Mythread mythread = new Mythread();
            mythread.start();
//            Thread.sleep(1000);
//            mythread.interrupt();
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.interrupted());
            System.out.println(mythread.getName());
            mythread.isInterrupted();
            System.out.println("是否停止1？="+mythread.interrupted());
            System.out.println("是否停止2？="+mythread.interrupted());
        }catch(Exception e){

        }
    }
}
