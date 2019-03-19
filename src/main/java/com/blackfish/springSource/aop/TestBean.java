package com.blackfish.springSource.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/18 19:57
 * @Description:
 */
public class TestBean {

    private String testStr ="pc ";

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }

    public void test(){
        System.out.println("test");
    }

    public static void main(String arg[]){
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/aoptest.xml");
        TestBean testBean = (TestBean)context.getBean("aopTestBean");
        testBean.test();
    }
}
