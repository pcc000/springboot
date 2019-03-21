package com.blackfish.springSource.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/20 14:29
 * @Description:
 */
public class EnhancerDemo {

    public static void main(String arg[]){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodInterceptorImpl());


        EnhancerDemo demo = (EnhancerDemo)enhancer.create();
        demo.test();

        System.out.println(demo);
    }

    public void test(){
        System.out.println("enhancer test");
    }

    public static class MethodInterceptorImpl implements MethodInterceptor{
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("before============"+method);
            Object object = methodProxy.invokeSuper(o,objects);
            System.out.println("after==========="+method);
            return object;
        }
    }
}
