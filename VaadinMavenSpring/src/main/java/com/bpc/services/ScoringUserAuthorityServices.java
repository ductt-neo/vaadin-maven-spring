package com.bpc.services;

import com.bpc.model.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/18/11
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ScoringUserAuthorityServices {

    @Transactional(readOnly = true)
    ScoringUser getUserByName(String userName) throws Exception;

    @Transactional(readOnly = true)
    List<ScoringUser> getAllUsers() throws Exception;

    @Transactional(readOnly = true)
    List<ScoringUserRole> getAllAuthorities()  throws Exception;

    @Transactional(readOnly = true)
    List<String> getDistinctAuthorities()  throws Exception;

    @Transactional(propagation = Propagation.REQUIRED)
    void insertUser(ScoringUser user) throws Exception;

    @Transactional(propagation = Propagation.REQUIRED)
    void updateUser(ScoringUser user) throws Exception;

    @Transactional(propagation = Propagation.REQUIRED)
    void deleteUser(ScoringUser user) throws Exception;
}
