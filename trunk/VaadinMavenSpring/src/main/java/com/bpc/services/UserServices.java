package com.bpc.services;

import com.bpc.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/16/11
 * Time: 11:09 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserServices {
    public List<User> getAllUser()throws SQLException;
}
