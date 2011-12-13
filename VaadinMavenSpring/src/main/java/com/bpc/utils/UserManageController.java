package com.bpc.utils;

import com.bpc.model.ScoringUser;
import com.bpc.model.ScoringUserRole;
import com.bpc.services.ScoringUserAuthorityServices;
import com.vaadin.data.util.BeanItemContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/16/11
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */

@Component
public class UserManageController {

    @Autowired(required=true)
    private ScoringUserAuthorityServices scoringUserAuthorityServices;

    public List<String> getAllAuthorities() throws Exception{
        List<String> authorities = scoringUserAuthorityServices.getDistinctAuthorities();
        /*BeanItemContainer<String> authorityDataList =
                new BeanItemContainer<String>(String.class, authorities);
        authorityDataList.sort(new Object[]{ClassFieldNameUtils.getFieldNames(ScoringUser.class)}, new boolean[]{true});*/
        return authorities;
    }

    public BeanItemContainer<ScoringUser> getAllUsers() throws Exception{
        List<ScoringUser> users = scoringUserAuthorityServices.getAllUsers();
        BeanItemContainer<ScoringUser> userDataList =
                new BeanItemContainer<ScoringUser>(ScoringUser.class, users);
        userDataList.sort(new Object[]{ClassFieldNameUtils.getFieldNames(ScoringUser.class)}, new boolean[]{true});
        return userDataList;
    }

    public void createScoringUser(ScoringUser user) throws Exception{
         scoringUserAuthorityServices.insertUser(user);
    }

    public void updateScoringUser(ScoringUser user) throws Exception{

        List<ScoringUserRole> newRoles = new ArrayList<ScoringUserRole>();
        /*for(String authority:user.getStringAuthorities()){
             ScoringUserRole userRole =new ScoringUserRole();
            userRole.setUserName(user.getUserName());
            userRole.setAuthority(authority);
            newRoles.add(userRole);
        }
        user.setRoles(newRoles);*/

        scoringUserAuthorityServices.updateUser(user);
    }

    public void deleteScoringUser(String userName) throws Exception{
        scoringUserAuthorityServices.deleteUser(new ScoringUser(userName=userName));
    }
}
