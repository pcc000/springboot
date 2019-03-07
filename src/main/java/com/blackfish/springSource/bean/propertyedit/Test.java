package com.blackfish.springSource.bean.propertyedit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/7 17:20
 * @Description:
 */
public class Test {

    public static void main(String arg[]){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/propertyedit/propertyedit.xml");
        System.out.println(applicationContext.getBean("test"));
    }
}
