package com.blackfish.springSource.profile;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/7 15:19
 * @Description:
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    public MyClassPathXmlApplicationContext(String configLocation) {
        super(configLocation);
    }

    @Override
    protected void initPropertySources() {
        getEnvironment().setActiveProfiles("pro");
    }
}
