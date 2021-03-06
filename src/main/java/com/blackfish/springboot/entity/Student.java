package com.blackfish.springboot.entity;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/10/25 19:36
 * @Description:
 */
public class Student {

    public Student(String name,Integer age) {
        this.age = age;
        this.name = name;
    }

    private Integer id;

    private Integer age;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
