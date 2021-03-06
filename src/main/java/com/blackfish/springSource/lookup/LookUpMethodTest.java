package com.blackfish.springSource.lookup;

/**
 * @Auther: shuyiwei
 * @Date: 2021/3/6 16:11
 * @Description:
 */
public abstract class LookUpMethodTest {
    public void play(){
        this.getBean().play();
    }
    public abstract  Player getBean();
}
