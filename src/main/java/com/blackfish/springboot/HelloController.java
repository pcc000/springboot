package com.blackfish.springboot;

import com.blackfish.springboot.properties.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "hello  "+sudentPreperties.getName()+sudentPreperties.getAge();
    }
}
