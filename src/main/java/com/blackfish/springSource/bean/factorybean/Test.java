package com.blackfish.springSource.bean.factorybean;

import com.blackfish.springSource.bean.TestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/6 13:26
 * @Description:
 */
public class Test {

    public static void main(String arg[]){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("bean/factorybean/StudentFactoryBean.xml"));
        System.out.println(bf.getBean("student"));
        System.out.println(bf.getBean("&student"));
    }
}
