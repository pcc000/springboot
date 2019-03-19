package com.blackfish.springSource.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/18 19:59
 * @Description:
 */
@Aspect
public class AspectJTest {

    @Pointcut("execution(* *.test(..))")
    public void test1(){

    }

    @Before("test1()")
    public void beforeTest(){
        System.out.println("before test");
    }

    @After("test1()")
    public void afterTest(){
        System.out.println("after test");
    }

    @Around("test1()")
    public Object aroundTest(ProceedingJoinPoint point){
        System.out.println("around before 1");
        Object o =null;
        try {
            o = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after 1");
        return o;
    }
}
