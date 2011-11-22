package com.bpc.filter;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/17/11
 * Time: 10:22 AM
 * To change this template use File | Settings | File Templates.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.*;

public class HttpServletRequestApplication
       implements HttpServletRequestListener {

    public void onRequestStart(HttpServletRequest request,
                               HttpServletResponse response) {
        System.out.println("[Start of request");
        System.out.println(" Query string: " +
                           request.getQueryString());
        System.out.println(" Path: " +
                           request.getPathInfo());
    }

    public void onRequestEnd(HttpServletRequest request,
                             HttpServletResponse response) {
        System.out.println(" End of request]");
    }
}
