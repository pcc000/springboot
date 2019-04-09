package com.blackfish.springSource.tx;

import java.util.List;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/21 19:30
 * @Description:
 */
public interface UserService {

     void save(User user);

     List<User> getUsers();
}
