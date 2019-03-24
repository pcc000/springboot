package com.blackfish.springSource.mybatis;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/23 11:00
 * @Description:
 */
public interface UserMapper {

    public void insertUser(User user);

    public User getUser(Integer id);
}
