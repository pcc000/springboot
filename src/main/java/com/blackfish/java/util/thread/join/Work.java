package com.blackfish.java.util.thread.join;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/10 14:41
 * @Description:
 */
public class Work implements Runnable {

    private String name;

    public Work(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+"is working");
    }
}
