package com.bpc.security;

import com.bpc.dao.ScoringUserAuthorityDao;
import com.bpc.dao.ScoringUserDao;
import com.bpc.model.ScoringUser;
import com.bpc.model.ScoringUserAuthority;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/18/11
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoringUserAuthenticationProvider extends DaoAuthenticationProvider {

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String principal = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        String encodedPassword = getPasswordEncoder().encodePassword(password,null);

        UserDetails userDetails =  getUserDetailsService().loadUserByUsername(principal);

        if (userDetails!=null && userDetails.getPassword().equals(encodedPassword)){
               return new UsernamePasswordAuthenticationToken(principal,
                    encodedPassword ,
                    userDetails.getAuthorities());
        }
        throw new BadCredentialsException("Password does not match for " + principal);
    }

    public boolean supports(Class<? extends Object> aClass) {
        return true;
    }
}
