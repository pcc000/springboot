package com.blackfish.java;

import com.blackfish.springboot.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/4/12 11:30
 * @Description:
 */
public class Test {

    public int[] twoSum(int[] arg, int target){
        for(int i=0;i<arg.length;i++){
            for(int j=i+1;j<arg.length;j++){
                if(arg[i]+arg[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("no two nums add equals target");
    }


    public static void main(String[] args) {
//
        List<Student> students=new ArrayList<>();
        students.add(new Student("李四",18));
        students.add(new Student("王五",18));
        students.add(new Student("张三",12));
        students.add(new Student("麻子",38));
        //过滤
        Long s = students.stream().filter(sss->sss.getAge().equals(15)).count();
        System.out.println(s);
    }
}
