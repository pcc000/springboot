package com.blackfish.java.util.lamble;

import com.blackfish.java.util.common.JsonUtil;
import com.blackfish.springboot.entity.Student;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Auther: shuyiwei
 * @Date: 2019/9/26 11:00
 * @Description:
 */
public class MapTest {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("123");
        s1.setAge(12321);
        Student s2 = new Student();
        s2.setName("123");
        s2.setAge(222);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);

        Map<String,List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(JsonUtil.toMap(map));

        FutureTask<Integer> integerFutureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });

        Integer result = null ;

        FutureTask<Integer> integer1FutureTask = new FutureTask<>(new Runnable(){
            @Override
            public void run() {

            }
        },result);
    }
}
