package com.blackfish.springSource.aware;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/4 10:45
 * @Description:
 */
public class Test {

    public static void main(String arg[]){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:aware/application_aware.xml");

        User user = applicationContext.getBean(User.class);
        System.out.println(String.format("实现了BeanNameAware接口的信息BeanId=%s,所有信息=%s",user.getId(),user.toString()));

        User1 user1 = applicationContext.getBean(User1.class);
        System.out.println(String.format("实现了BeanNameAware接口的信息BeanId=%s,所有信息=%s",user1.getId(),user1.toString()));

        //===beanFactoryAware
        BeanFactoryAwareTest beanFactoryAwareTest = (BeanFactoryAwareTest) applicationContext.getBean("beanFactoryAwareTest");
        beanFactoryAwareTest.testBeanFactoryAware();

    }
}
