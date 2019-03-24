package com.blackfish.springSource.mybatis;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/23 10:54
 * @Description:
 */
public class User {

    private Integer id;

    private String name;

    private Integer age;

    public User(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    //必须有无参构造方法，不然依据UserMapper.xml中的配置，在查询数据库时，将不能反射构造出User实例
    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
