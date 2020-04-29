package com.blackfish.java.classLoad;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/1/8 10:51
 * @Description:
 */
public class Parent extends SecondAbstractParent {
    @Override
    public void register() {

    }

    @Override
    public void unregister() {

    }

    static{
        System.out.println("parent static run!!!");
    }

    {
        System.out.println("parent no static run!!!");
    }

    public Parent(){
        System.out.println("parent constract method run !!!");
    }

    public Parent(String name){
        System.out.println("parent argument constract method run !!!");
    }
}
