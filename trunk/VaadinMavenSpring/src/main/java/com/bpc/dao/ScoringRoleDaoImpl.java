package com.bpc.dao;

import com.bpc.model.ScoringRole;
import com.bpc.model.ScoringUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Date: 11/21/11
 * Time: 2:25 PM
 * Scoring Role Dao Implementation
 */

public class ScoringRoleDaoImpl
        extends AbstractHibernateDAOImpl<ScoringRole, String> implements ScoringRoleDao {

    @Override
    protected Class<ScoringRole> getDomainClass() {
        return ScoringRole.class;
    }

    public List<ScoringRole> getAllRoles() throws Exception {
        List<ScoringRole> roles = getHibernateTemplate().find("select r from ScoringRole r");
        return roles;
    }

    public ScoringRole getRoleById(String id) throws Exception {
        ScoringRole role = null;
        List<ScoringRole> roles = getHibernateTemplate().find("from ScoringRole r where r.id=?", id);
        if(roles!=null && roles.size()>0)
              role = roles.get(0);
        return role;
    }
}
