package com.blackfish.java.design.factory.method;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/5/17 10:08
 * @Description:
 */
public class AppleFactory implements FruitFactory {

    @Override
    public Fruit createFruit() {
        return new Apple();
    }
}
