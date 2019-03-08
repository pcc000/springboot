package com.blackfish.springSource.bean.beanfactoryPostProcessor;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/8 15:02
 * @Description:
 */
public class CustomizeBeanFactoryPostProcessorDemo {

    public static void main(String arg[]){

        ConfigurableListableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("bean/beanfactoryPostProcessor/beanfactoryPostProcessor.xml"));

        BeanFactoryPostProcessor beanFactoryPostProcessor = (BeanFactoryPostProcessor)bf.getBean("customizeBeanFactoryPostProcessor");

        beanFactoryPostProcessor.postProcessBeanFactory(bf);

        System.out.println(bf.getBean("testBean"));


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/beanfactoryPostProcessor/beanfactoryPostProcessor.xml");
        System.out.println(bf.getBean("testBean"));
    }
}
