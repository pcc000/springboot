package com.blackfish.springSource.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/21 19:57
 * @Description:
 */
public class Test {

    public static void main(String arg[]){
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc/jdbc.xml");
        UserService userService = (UserService)context.getBean("userService");

        User user = new User("123",2,"f");
        userService.save(user);

        List<User> lists = userService.getUsers();

        for(User user1 : lists){
            System.out.println(user1.toString());
        }

    }
}
