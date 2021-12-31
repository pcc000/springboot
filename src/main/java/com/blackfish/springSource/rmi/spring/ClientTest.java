package com.blackfish.springSource.rmi.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/28 15:46
 * @Description:
 */
public class ClientTest {

    public static void main(String[] args) throws Exception{
//        ApplicationContext context = new ClassPathXmlApplicationContext("rmi/spring/spring-rmi-client.xml");
//
//        HelloRMIService service = (HelloRMIService) context.getBean("myClient");
//        System.out.println(service.getAdd(2,4));


        HelloRMIService helloRMIService = (HelloRMIService)Naming.lookup("helloRMIService");
        String result = helloRMIService.sayHello("pcc");
        System.out.println(result);

    }
}
