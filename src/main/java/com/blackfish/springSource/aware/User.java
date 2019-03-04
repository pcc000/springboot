package com.blackfish.springSource.aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/4 10:32
 * @Description:
 */
public class User implements BeanNameAware {


    private String id;

    private String name;

    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void setBeanName(String name) {
        id = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
