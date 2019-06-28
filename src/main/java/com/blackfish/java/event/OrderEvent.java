package com.blackfish.java.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @Auther: SZSS
 * @Date: 2019/6/28 20:16
 * @Description:
 */
@Component
public class OrderEvent extends ApplicationEvent {

    public OrderEvent(Object source) {
        super(source);
        System.out.println("orderEvent start");
    }
}
