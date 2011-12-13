package com.bpc.dao;

import com.bpc.model.ScoringRole;
import com.bpc.model.ScoringUser;

import java.util.List;

/*
 * Date: 11/21/11
 * Time: 2:24 PM
 * User role DAO
 */
public interface ScoringRoleDao extends AbstractDAO<ScoringRole,String>{
    public List<ScoringRole> getAllRoles() throws Exception;
    public ScoringRole getRoleById(String id) throws Exception;
}
