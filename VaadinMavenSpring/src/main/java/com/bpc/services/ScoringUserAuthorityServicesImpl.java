package com.bpc.services;

import com.bpc.dao.*;
import com.bpc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/18/11
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("scoringUserAuthorityService")
@Transactional
public class ScoringUserAuthorityServicesImpl implements ScoringUserAuthorityServices, UserDetailsService {
    @Autowired
    private ScoringUserDao scoringUserDao;
    @Autowired
    private ScoringUserRoleDao scoringUserAuthorityDao;

    @Transactional(readOnly = true)
    public ScoringUser getUserByName(String userName) throws Exception{
        ScoringUser user = null;
        try {
            user = scoringUserDao.getUserByName(userName);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return user;
    }

    @Transactional(readOnly = true)
    public List<ScoringUser> getAllUsers()  throws Exception{
        List<ScoringUser> users = null;
        try {
            users = scoringUserDao.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return users;
    }

    @Transactional(readOnly = true)
    public List<ScoringUserRole> getAllAuthorities()  throws Exception{
        List<ScoringUserRole> roles = null;
        try {
//            roles = scoringUserAuthorityDao.getAllUserAuthorities();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Transactional(readOnly = true)
    public List<String> getDistinctAuthorities() throws Exception {
        List<String> authorities = null;
        try {
//            authorities = scoringUserAuthorityDao.getDistinctUserAuthorities();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorities;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertUser(ScoringUser user) throws Exception {
        try {
            ScoringUser existUser = getUserByName(user.getUserName());
            if (existUser != null) {
                throw new Exception("User is existing");
            }
            scoringUserDao.insertUser(user);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(ScoringUser user) throws Exception {
        try {
            ScoringUser existUser = getUserByName(user.getUserName());
            if (existUser == null) {
                throw new Exception("User does not exist");
            }
            scoringUserDao.update(user);
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(ScoringUser user) throws Exception {
        try {
            ScoringUser existUser = getUserByName(user.getUserName());
            if (existUser == null) {
                throw new Exception("User does not exist");
            }
            scoringUserDao.delete(user);
        } catch (Exception e) {
            throw e;
        }
    }

    /*Override Method*/
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException, DataAccessException {
        User springUser = null;
        try {
        	List<ScoringUser> users= scoringUserDao.getAllUsers();
        	
            ScoringUser user = scoringUserDao.getUserByName(s);
            if (user != null) {
                String userName = user.getUserName();
                String password = user.getPassword();
                boolean enabled = user.getEnabled().equals("Y") ? true : false;
                boolean accountNonExpired = true;
                boolean credentialsNonExpired = true;
                boolean nonLocked = true;
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                /*for (ScoringUserRole role : user.getRoles()) {
                    GrantedAuthorityImpl springAuthority = new GrantedAuthorityImpl(role.getAuthority());
                    authorities.add(springAuthority);
                }*/
                springUser = new User(userName, password, enabled, accountNonExpired, credentialsNonExpired
                        , nonLocked, authorities);
            }else {
                throw new BadCredentialsException("User " + s +" does not exist!");
            }
        } catch (UsernameNotFoundException e1) {
            throw e1;
        } catch (DataAccessException e2) {
            throw e2;
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return springUser;
    }

}
