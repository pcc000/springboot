package com.blackfish.springSource.bean.beanfactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.Set;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/8 14:11
 * @Description:
 */
public class CustomizeBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    private Set<String> value;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String []beanNames = beanFactory.getBeanDefinitionNames();
        for(String beanName : beanNames){
            BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
            StringValueResolver resolver = new StringValueResolver() {
                @Override
                public String resolveStringValue(String strVal) {
                    if(isContain(strVal)) return "******";
                    return strVal;
                }
            };
            BeanDefinitionVisitor vistor = new BeanDefinitionVisitor(resolver);
            vistor.visitBeanDefinition(bd);
        }
    }

    public boolean isContain(String value){
        String potentialObscenties  = value.toUpperCase();
        return this.value.contains(potentialObscenties);
    }

    public void setValue(Set<String> value) {
        this.value = value;
    }
}
