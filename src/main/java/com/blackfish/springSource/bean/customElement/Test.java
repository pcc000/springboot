package com.blackfish.springSource.bean.customElement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/11/8 14:57
 * @Description:
 */
public class Test {

    public static void main(String []arg){
        ApplicationContext context = new ClassPathXmlApplicationContext("customElement/UserTest.xml");
        User user = (User)context.getBean("test");
        System.out.println(user.getName());
    }
}
