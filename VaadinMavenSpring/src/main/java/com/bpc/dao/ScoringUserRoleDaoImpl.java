package com.bpc.dao;

import com.bpc.model.ScoringUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/21/11
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */

public class ScoringUserRoleDaoImpl
        extends AbstractHibernateDAOImpl<ScoringUserRole, String> implements ScoringUserRoleDao {

    @Override
    protected Class<ScoringUserRole> getDomainClass() {
        return ScoringUserRole.class;
    }

    public List<ScoringUserRole> getAllUserRoles() {
        List<ScoringUserRole> userRoles = getList();
        return userRoles;
    }
}
