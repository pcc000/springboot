package com.blackfish.java.design.factory.simple;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/16 16:05
 * @Description:
 */
public class SimpleFactory {

    public static Fruit createFruit(String type){
        if("apple".equals(type)){
            return new Apple();
        }else if("balana".equals(type)){
            return new Balana();
        }
        return null;
    }

    public static void main(String[] args) {
        Apple apple = (Apple)SimpleFactory.createFruit("apple");
        Balana balana = (Balana)SimpleFactory.createFruit("balana");
    }

}
