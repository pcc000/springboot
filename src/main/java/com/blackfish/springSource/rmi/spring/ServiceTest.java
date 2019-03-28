package com.blackfish.springSource.rmi.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/28 15:44
 * @Description:
 */
public class ServiceTest {

    public static void main(String[] args) throws Exception{

//        System.out.println(java.net.InetAddress.getLocalHost().getHostAddress());

        new ClassPathXmlApplicationContext("rmi/spring/spring-rmi-server.xml");
        System.out.println("spring rmi service start:");
    }
}
