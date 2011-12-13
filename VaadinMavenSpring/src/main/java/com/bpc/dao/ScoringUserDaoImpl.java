package com.bpc.dao;

import com.bpc.model.ScoringUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/21/11
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */

public class ScoringUserDaoImpl
        extends AbstractHibernateDAOImpl<ScoringUser, String> implements ScoringUserDao {

    @Override
    protected Class<ScoringUser> getDomainClass() {
        return ScoringUser.class;
    }

    public List<ScoringUser> getAllUsers()  throws Exception{
        List<ScoringUser> users = getHibernateTemplate().find("select u from ScoringUser u");
        return users;
    }

    public ScoringUser getUserByName(String userName)  throws Exception{
        ScoringUser user = null;
        List<ScoringUser> users = getHibernateTemplate().find("from ScoringUser u where u.userName=?", userName);
        if(users!=null && users.size()>0)
              user = users.get(0);
        return user;
    }

    public void insertUser(ScoringUser user) throws Exception {
        getHibernateTemplate().save(user);
    }

    public void updateUser(ScoringUser user) throws Exception {
        getHibernateTemplate().update(user);
    }

    public void deleteUser(ScoringUser user) throws Exception {
        getHibernateTemplate().delete(user);
    }
}
