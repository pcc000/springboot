package com.blackfish.springSource.proxy.jdk;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/20 13:58
 * @Description:
 */
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("-----------add------------");
    }
}
