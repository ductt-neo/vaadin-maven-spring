package com.bpc.dao;

import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;
import com.bpc.model.ScoringUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public List<ScoringUser> getAllUsers() {
        List<ScoringUser> users = getList();
        return users;
    }

    public ScoringUser getUserByName(String userName) {
        ScoringUser user = null;
        List<ScoringUser> users = getHibernateTemplate().find("from ScoringUser u where u.userName=?", userName);
        if(users!=null && users.size()>0)
              user = users.get(0);
        return user;
    }
}
