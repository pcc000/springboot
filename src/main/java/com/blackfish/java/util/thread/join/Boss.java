package com.blackfish.java.util.thread.join;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/10 14:43
 * @Description:
 */
public class Boss implements Runnable {

    private String name;

    public Boss(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Boss check work");
    }
}
