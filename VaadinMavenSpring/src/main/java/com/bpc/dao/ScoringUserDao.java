package com.bpc.dao;

import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;
import com.bpc.model.ScoringUser;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/21/11
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ScoringUserDao extends AbstractDAO<ScoringUser,String>{
    public List<ScoringUser> getAllUsers() throws Exception;
    public ScoringUser getUserByName(String userName) throws Exception;
    public void insertUser(ScoringUser user) throws Exception;
    public void updateUser(ScoringUser user) throws Exception;
    public void deleteUser(ScoringUser user) throws Exception;
}
