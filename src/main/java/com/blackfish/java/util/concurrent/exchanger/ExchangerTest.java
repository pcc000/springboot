package com.blackfish.java.util.concurrent.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/26 17:16
 * @Description:交换机
 *  java.util.concurrent.Exchanger 类表示一种两个线程可以进行互相交换对象的会和点
 */
public class ExchangerTest {

    public static void main(String arg[]){

        Exchanger exchanger = new Exchanger();

        ExchangerRunnable exchangerRunnable1 =
                new ExchangerRunnable(exchanger, "A");

        ExchangerRunnable exchangerRunnable2 =
                new ExchangerRunnable(exchanger, "B");

        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();


    }

}
