package com.bpc.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: Bui_qt
 * Date: 11/25/11
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */

@Component
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(javax.servlet.http.HttpServletRequest request,
                                javax.servlet.http.HttpServletResponse response,
                                Authentication authentication)
            throws java.io.IOException, javax.servlet.ServletException {

        response.sendRedirect("/vaadin");

    }
}
