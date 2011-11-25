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
    private ScoringUserAuthorityDao scoringUserAuthorityDao;
    @Transactional
    public ScoringUser getUserAuthority(String userName) {
        return scoringUserDao.getUserByName(userName);
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException, DataAccessException {
        User springUser = null;
        try {
            ScoringUser user = scoringUserDao.getUserByName(s);
            if (user != null) {
                String userName = user.getUserName();
                String password = user.getPassword();
                boolean enabled = user.getEnabled().equals("Y") ? true : false;
                boolean accountNonExpired = true;
                boolean credentialsNonExpired = true;
                boolean nonLocked = true;
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                for (ScoringUserAuthority authority : user.getAuthorities()) {
                    GrantedAuthorityImpl springAuthority = new GrantedAuthorityImpl(authority.getAuthority());
                    authorities.add(springAuthority);
                }
                springUser = new User(userName, password, enabled, accountNonExpired, credentialsNonExpired
                        , nonLocked, authorities);
            }else {
                throw new BadCredentialsException("User " + s +" does not exist!");
            }
        } catch (UsernameNotFoundException e1) {
            throw e1;
        } catch (DataAccessException e2) {
            throw e2;
        }
        return springUser;
    }
}
