package com.blackfish.springboot;

import com.blackfish.springboot.properties.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/10/23 14:05
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    private StudentProperties sudentPreperties;

    @Value("${name}")
    private String name;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!"+name;
    }

    @RequestMapping("/hello2")
    public String hello2(){
        return "hello  " + sudentPreperties.getName() + sudentPreperties.getAge();
    }

    public static void main(String []arg) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
        String hostAddress = address.getHostAddress();//192.168.0.121

        System.out.println(hostAddress);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.blackfish.springboot.order");
    }
}
