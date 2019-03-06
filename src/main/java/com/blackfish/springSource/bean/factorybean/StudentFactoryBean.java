package com.blackfish.springSource.bean.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/6 11:13
 * @Description:
 */
public class StudentFactoryBean implements FactoryBean<Student> {

    private String studentInfo;

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Student getObject() throws Exception {
        if (this.studentInfo == null) {
            throw new IllegalArgumentException("'studentInfo' is required");
        }

        // 分割属性
        String[] splitStudentInfo = studentInfo.split(",");
        if (null == splitStudentInfo || splitStudentInfo.length != 3) {
            throw new IllegalArgumentException("'studentInfo' config error");
        }

        // 创建Student并填充属性
        Student student = new Student();
        student.setName(splitStudentInfo[0]);
        student.setAge(Integer.valueOf(splitStudentInfo[1]));
        student.setClassName(splitStudentInfo[2]);
        return student;
    }

    @Override
    public Class<?> getObjectType() {
        return StudentFactoryBean.class;
    }

    public void setStudentInfo(String studentInfo) {
        this.studentInfo = studentInfo;
    }
}
