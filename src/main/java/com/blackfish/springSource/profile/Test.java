package com.blackfish.springSource.profile;

import com.blackfish.springSource.bean.factorybean.StudentFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/7 15:21
 * @Description:
 */
public class Test {

    public static void main(String arg[]){
        ApplicationContext applicationContext = new MyClassPathXmlApplicationContext("classpath:profile/Profile.xml");
        System.out.println(applicationContext.getBean("student1"));

        System.out.println(applicationContext.getBean("student1"));
    }
}
