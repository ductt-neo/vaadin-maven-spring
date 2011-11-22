package com.bpc.dao;

import com.bpc.model.User;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/16/11
 * Time: 10:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class FEUserDaoImpl extends SimpleJdbcDaoSupport implements FEUserDao {


    public List<User> getAllUser() throws SQLException {
        String query = "select * from t_web_user";
        List<User> users = getSimpleJdbcTemplate().query(
                query, ParameterizedBeanPropertyRowMapper.newInstance(User.class));
//                new RowMapper<User>() {
//                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        User user = new User();
//                        user.setPersonId(rs.getInt("personId"));
//                        user.setLogin(rs.getString("login"));
//                        user.setName(rs.getString("name"));
//                        return user;
//                    }
//                });
        return users;
    }
}