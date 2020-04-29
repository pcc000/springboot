package com.blackfish.java.counter;

/**
 * @Auther: shuyiwei
 * @Date: 2020/4/28 19:31
 * @Description:
 */
public class CounterTest {

    public static void main(String[] args) throws InterruptedException {
        final  Counter counter = new CounterCAS();

        for(int i=0;i<2;i++){
            new Thread(()->{
                long begin = System.nanoTime();
                for(int j=0;j<10000;j++){
                    counter.incr();
                }
                System.out.println("运行时间："+(System.nanoTime()-begin));
            }).start();
        }
        Thread.sleep(6000l);
        System.out.println("result:"+counter.get());
    }
}
