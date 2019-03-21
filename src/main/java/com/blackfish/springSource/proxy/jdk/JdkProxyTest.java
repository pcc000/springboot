package com.blackfish.springSource.proxy.jdk;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/20 14:07
 * @Description:
 */
public class JdkProxyTest {
    public static void main(String arg[]){
        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocation = new MyInvocationHandler(userService);
        UserService user = (UserService)invocation.getProxy();
        user.add();
    }
}
