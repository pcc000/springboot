package com.blackfish.springSource.mybatis.spring;


import com.blackfish.springSource.mybatis.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/24 22:56
 * @Description:
 */
public class SpringMybatisTest {

    public static void main(String arg[]){
        ApplicationContext context = new ClassPathXmlApplicationContext("mybatis/spring/spring-mybatis.xml");
        UserMapper mapper = (UserMapper)context.getBean("userMapper");
        System.out.println(mapper.getUser(1770));
    }
}
