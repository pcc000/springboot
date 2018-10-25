package com.blackfish.springboot.mapper;

import com.blackfish.springboot.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: chengchengpeng
 * @Date: 2018/10/25 19:37
 * @Description:
 */
@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student")
    List<Student> findAll();
}
