package com.blackfish.springSource.tx;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @Auther: chengchengpeng
 * @Date: 2019/3/21 19:31
 * @Description:
 */
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into user(name,age,sex)values(?,?,?)",
                new Object[]{user.getName(),user.getAge(),user.getSex()});
        throw new RuntimeException("wrwer");
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("select * from user",new UserRowMapper());
    }
}
