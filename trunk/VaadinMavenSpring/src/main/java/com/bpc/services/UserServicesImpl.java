package com.bpc.services;

import com.bpc.dao.FEUserDao;
import com.bpc.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/16/11
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserServicesImpl implements UserServices{
    private FEUserDao feUserDao;

    public void setFeUserDao(FEUserDao feUserDao) {
        this.feUserDao = feUserDao;
    }

    public List<User> getAllUser()throws SQLException {
        return this.feUserDao.getAllUser();
    }
}
