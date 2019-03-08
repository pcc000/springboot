package com.blackfish.springSource.bean.beanfactoryPostProcessor;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/8 13:32
 * @Description:
 */
public class Config {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void main(String arg[]){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean/beanfactoryPostProcessor/beanfactoryPostProcessor.xml");
        Config config = (Config)applicationContext.getBean("message");
        System.out.println(config.value);
    }
}
