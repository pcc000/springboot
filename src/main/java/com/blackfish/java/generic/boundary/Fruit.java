package com.blackfish.java.generic.boundary;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/7 10:31
 * @Description:
 */
public class Fruit extends Object{

    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
