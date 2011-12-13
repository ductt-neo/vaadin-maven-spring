package com.bpc.dao;

import com.bpc.model.ScoringUserRole;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/21/11
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ScoringUserRoleDao extends AbstractDAO<ScoringUserRole,String>{
    List<ScoringUserRole> getAllUserRoles();
}
