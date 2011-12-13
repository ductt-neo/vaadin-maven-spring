package com.bpc.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

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
