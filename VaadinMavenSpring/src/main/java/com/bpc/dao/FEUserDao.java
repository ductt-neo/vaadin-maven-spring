package com.bpc.dao;

import java.sql.SQLException;
import java.util.List;
import com.bpc.model.User;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/16/11
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public interface  FEUserDao {
    public List<User> getAllUser()throws SQLException;
}
