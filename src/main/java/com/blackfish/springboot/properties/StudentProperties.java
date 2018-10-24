package com.blackfish.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/10/23 15:37
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "student")
public class StudentProperties {
    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
