package com.bpc.dao;

import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;
import com.bpc.model.ScoringUser;

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
}
