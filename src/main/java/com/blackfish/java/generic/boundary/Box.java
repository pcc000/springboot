package com.blackfish.java.generic.boundary;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/7 10:35
 * @Description:
 */
public class Box<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return t.toString();
    }
}
