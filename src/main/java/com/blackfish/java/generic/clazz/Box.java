package com.blackfish.java.generic.clazz;

import java.util.Collection;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/7 10:18
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

    public static void main(String[] args) {
        Box<String> boxString = new Box<>();
        boxString.setT("wer");
        System.out.println(boxString.getT());

        Box boxInteger = new Box();
        boxInteger.setT(123);
        System.out.println(boxInteger.getT());
    }
}

