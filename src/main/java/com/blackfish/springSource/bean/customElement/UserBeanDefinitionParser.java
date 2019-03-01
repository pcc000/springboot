package com.blackfish.springSource.bean.customElement;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/11/8 13:18
 * @Description:
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return User.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String  user = element.getAttribute("name");
        String email = element.getAttribute("email");
        if(StringUtils.hasText(user)){
            builder.addPropertyValue("name",user);
        }
        if(StringUtils.hasText(email)){
            builder.addPropertyValue("email",email);
        }
    }

}
