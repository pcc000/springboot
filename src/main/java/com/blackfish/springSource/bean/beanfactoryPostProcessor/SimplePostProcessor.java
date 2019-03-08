package com.blackfish.springSource.bean.beanfactoryPostProcessor;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/8 15:00
 * @Description:
 */
public class SimplePostProcessor {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SimplePostProcessor{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
