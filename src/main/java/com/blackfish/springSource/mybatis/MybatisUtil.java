package com.blackfish.springSource.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/23 11:31
 * @Description:
 */
public class MybatisUtil {

    private final static SqlSessionFactory sqlSessionFactory;

    static{
        String resource = "mybatis/mybatis-config.xml";
        Reader reader = null;
        try{
            reader = Resources.getResourceAsReader(resource);
        }catch(IOException e){

        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

}
