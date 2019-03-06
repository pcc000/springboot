package com.blackfish.springSource.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.beans.factory.parsing.NullSourceExtractor;
import org.springframework.beans.factory.xml.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.HashMap;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/11/6 11:24
 * @Description:
 */
public class BeanFactoryTest {


    public static void main(String []arg){

        String relativelyPath=System.getProperty("user.dir");
        System.out.println(relativelyPath);

//        ClassPathResource resource = new ClassPathResource("DispatcherServlet.properties", DispatcherServlet.class);

//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("C:/Users/chengchengpeng/git/springboot/src/main/java/com/blackfish/springSource/bean/BeanFactory.xml"));
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("bean/BeanFactory.xml"));
        TestBean test = (TestBean) bf.getBean("test");
        System.out.println(test.getStr());

        DefaultBeanDefinitionDocumentReader reader = new DefaultBeanDefinitionDocumentReader();

//        new XmlReaderContext(new ClassPathResource("bean/BeanFactory.xml"), new FailFastProblemReporter(), new EmptyReaderEventListener(),
//                new NullSourceExtractor(), new XmlBeanDefinitionReader(), new PathMatchingResourcePatternResolver());
    }

}
