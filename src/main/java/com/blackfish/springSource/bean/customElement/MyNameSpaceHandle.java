package com.blackfish.springSource.bean.customElement;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/11/8 13:28
 * @Description:
 */
public class MyNameSpaceHandle extends NamespaceHandlerSupport {


    @Override
    public void init() {
        registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
    }
}
