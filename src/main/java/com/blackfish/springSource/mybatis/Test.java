package com.blackfish.springSource.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**s
 * @Auther: chengchengpeng
 * @Date: 2019/3/23 18:23
 * @Description:
 */
public class Test {

    static SqlSessionFactory sqlSessionFactory = null;
    static{
        sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
    }

    public static void main(String arg[]){
        Test test = new Test();
//        test.testAdd();
        test.testGet();
    }

    public void testAdd(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User("qqq",29);
            userMapper.insertUser(user);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public void testGet(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUser(1770);
            System.out.println(user.toString());
        }finally {
            sqlSession.close();
        }

    }
}
