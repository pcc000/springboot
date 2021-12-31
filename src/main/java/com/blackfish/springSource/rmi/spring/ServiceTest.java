package com.blackfish.springSource.rmi.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/28 15:44
 * @Description:
 */
public class ServiceTest {

    public static void main(String[] args) throws Exception{

//        System.out.println(java.net.InetAddress.getLocalHost().getHostAddress());

//        new ClassPathXmlApplicationContext("rmi/spring/spring-rmi-server.xml");
//        System.out.println("spring rmi service start:");

        HelloRMIService helloRMIService = new HelloRMIServiceImpl();

//        LocateRegistry.createRegistry(8088);

        Naming.bind("rmi://localhost:8088/helloRMIService",helloRMIService);

        System.out.println("register success");

    }
}
