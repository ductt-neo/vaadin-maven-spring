package com.bpc.utils;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/15/11
 * Time: 10:48 AM
 * To change this template use File | Settings | File Templates.
 */

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.WebApplicationContext;
import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContextHelper {

	private static ApplicationContext context;
	private static Application application;
	private static SpringContextHelper instance;

	private SpringContextHelper() {
		ServletContext servletContext = ((WebApplicationContext) application
				.getContext()).getHttpSession().getServletContext();
		context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);

	}

	public synchronized static SpringContextHelper getInstance(Application app) {
		application = app;
		if (instance == null) {
			instance = new SpringContextHelper();
		}
		return instance;

	}

	public synchronized static SpringContextHelper getInstance() {

		if (instance == null) {
			instance = new SpringContextHelper();
		}
		return instance;
	}

	public Object getBean(final String beanRef) {
		return context.getBean(beanRef);
	}

	public static ApplicationContext getContext() {
		return context;
	}
}
