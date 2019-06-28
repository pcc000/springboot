package com.blackfish.java.event;

import org.springframework.context.ApplicationListener;

/**
 * @Auther: SZSS
 * @Date: 2019/6/28 20:25
 * @Description:
 */
public class SmsListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent orderEvent) {
        System.out.println("sms send");
    }
}
