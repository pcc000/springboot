package com.blackfish.springboot.order;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/11/2 14:55
 * @Description:
 */
@Component
@Order(1)
public class DemoConfig1 {
    public DemoConfig1(){
        System.out.println("demoConfig1");
    }
}
