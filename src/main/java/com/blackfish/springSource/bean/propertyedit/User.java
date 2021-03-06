package com.blackfish.springSource.bean.propertyedit;

import java.util.Date;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/7 17:17
 * @Description:
 */
public class User {

    private String name;

    private Date brithDay;

    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBrithDay() {
        return brithDay;
    }

    public void setBrithDay(Date brithDay) {
        this.brithDay = brithDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", brithDay=" + brithDay +
                ", address=" + address +
                '}';
    }
}
