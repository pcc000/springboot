package com.blackfish.springSource.bean.customElement;

import com.blackfish.springSource.bean.TestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

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


//        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("customElement/UserTest.xml"));
//        User user1 = (User) bf.getBean("test");
//        System.out.println(user1.getName());
    }
}
