package com.blackfish.java.design.factory.method;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/17 10:13
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        Apple apple = (Apple)appleFactory.createFruit();

        BearFactory bearFactory = new BearFactory();
        Bear bear = (Bear)bearFactory.createFruit();
    }
}
