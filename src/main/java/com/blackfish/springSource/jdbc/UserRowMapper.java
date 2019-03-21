package com.blackfish.springSource.jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/21 19:26
 * @Description:
 */
public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("age"),resultSet.getString("sex"));
        return user;
    }
}
