package com.blackfish.springSource.lookup;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * @Auther: shuyiwei
 * @Date: 2021/3/6 17:23
 * @Description:
 */
public class James implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("James replace kobe");
        return null;
    }
}
