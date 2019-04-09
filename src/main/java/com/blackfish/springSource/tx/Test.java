package com.blackfish.springSource.tx;

import com.blackfish.springSource.tx.User;
import com.blackfish.springSource.tx.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/1 14:24
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("tx/tx.xml");
        UserService userService = (UserService)context.getBean("userService");

        User user = new User("123",2,"f");
        userService.save(user);

        List<User> lists = userService.getUsers();

        for(User user1 : lists){
            System.out.println(user1.toString());
        }
    }
}
