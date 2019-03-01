package com.blackfish.java.classLoad;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/1/8 10:54
 * @Description:
 */
public class Son extends Parent {

    static{
        System.out.println("son static run!!!");
    }

    {
        System.out.println("son no static run!!!");
    }

    public Son(){
        System.out.println("son constract method run!!!");
    }
}
