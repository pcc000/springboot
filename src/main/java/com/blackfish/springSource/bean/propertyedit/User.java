package com.blackfish.springSource.bean.propertyedit;

import java.util.Date;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/7 17:17
 * @Description:
 */
public class User {

    private Date brithDay;

    public Date getBrithDay() {
        return brithDay;
    }

    public void setBrithDay(Date brithDay) {
        this.brithDay = brithDay;
    }

    @Override
    public String toString() {
        return "User{" +
                "brithDay=" + brithDay +
                '}';
    }
}
