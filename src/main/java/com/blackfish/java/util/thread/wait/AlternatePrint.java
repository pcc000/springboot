package com.blackfish.java.util.thread.wait;

/**
 * @Auther: shuyiwei
 * @Date: 2020/11/23 20:23
 * @Description:
 */
public class AlternatePrint {

    private static Object o1 = new Object();

    private static int i=0;

    public static void main(String[] args) {
        Thread oddThread = new Thread(()->{
            synchronized (o1){
                for(;;){
                    if(i%2==1){
                        System.out.println("come in odd:"+i++);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        o1.notify();
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"oddNumber");
        Thread evenThread = new Thread(()->{
            synchronized (o1){
                for(;;){
                    if(i%2==0){
                        System.out.println("come in even:"+i++);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        o1.notify();
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        try {
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"even");

        oddThread.start();
        evenThread.start();

    }
}
