package com.blackfish.java.util.concurrent.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/26 17:16
 * @Description:
 */
public class ExchangerRunnable implements Runnable {

    Exchanger exchanger = null;
    Object o = null;

    public ExchangerRunnable(Exchanger exchanger, Object o) {
        this.exchanger = exchanger;
        this.o = o;
    }

    @Override
    public void run() {
        try {
            Object previous = this.o;

            this.o = this.exchanger.exchange(this.o);

            System.out.println(
                    Thread.currentThread().getName() +
                            " exchanged " + previous + " for " + this.o
            );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
