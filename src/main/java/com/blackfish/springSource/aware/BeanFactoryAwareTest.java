package com.blackfish.springSource.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/7 13:46
 * @Description:
 */
public class BeanFactoryAwareTest implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void testBeanFactoryAware(){
        User user = (User)beanFactory.getBean("user");
        System.out.println("testBeanFacotyAware");
        System.out.println(user.toString());
    }
}
