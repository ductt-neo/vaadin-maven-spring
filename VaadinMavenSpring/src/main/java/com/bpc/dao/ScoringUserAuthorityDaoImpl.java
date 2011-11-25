package com.bpc.dao;

import com.bpc.model.ScoringUser;
import com.bpc.model.ScoringUserAuthority;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/21/11
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoringUserAuthorityDaoImpl
        extends AbstractHibernateDAOImpl<ScoringUserAuthority, String> implements ScoringUserAuthorityDao {

    @Override
    protected Class<ScoringUserAuthority> getDomainClass() {
        return ScoringUserAuthority.class;
    }

    public List<ScoringUserAuthority> getAllUserAuthorities() {
        List<ScoringUserAuthority> userAuthorities = getList();
        return userAuthorities;
    }

}
