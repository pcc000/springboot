package com.blackfish.springSource.bean.factorybean;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/6 11:12
 * @Description:
 */
public class Student {

    private String name;

    private int age;

    private String className;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String classname) {
        this.className = classname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}
