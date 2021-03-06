package com.blackfish.springSource.lookup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: shuyiwei
 * @Date: 2021/3/6 16:13
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/lookup.xml");
        System.out.println("=======================");
        LookUpMethodTest  lookUpMethodTest = (LookUpMethodTest) applicationContext.getBean("lookUpMethodTest");
        lookUpMethodTest.play();

        Kobe  jamesReplaceKobe = (Kobe) applicationContext.getBean("k");
        jamesReplaceKobe.play();

    }
}
