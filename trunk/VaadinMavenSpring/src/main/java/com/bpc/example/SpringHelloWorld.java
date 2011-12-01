/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpc.example;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.bpc.example.io.DownloadableFileStream;
import com.bpc.example.service.ReportManager;
import com.bpc.ui.CalcWindow;
import com.bpc.ui.ScoringRuleWindow;
import com.bpc.ui.LoginWindow;
import com.bpc.ui.ScoringRuleTable;

import com.bpc.utils.SpringContextHelper;
import com.vaadin.event.Action;
import com.vaadin.terminal.gwt.server.WebApplicationContext;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Window;

/**
 * @author do_th
 */
// @Configurable(preConstruction = true)
public class SpringHelloWorld extends com.vaadin.Application {
	private static final Logger logger = Logger
			.getLogger(SpringHelloWorld.class);
	
	private Window mainWindow;
	private LoginWindow loginWindow;
	private Window currentChildWindow;

	private MenuBar menubar = new MenuBar();

	private MenuBar.MenuItem function;
	private MenuBar.MenuItem report;
	private MenuBar.MenuItem system;

	

	@Override
	public void init() {
		authenticateUser();
	}

	public void authenticateUser() {
		SpringContextHelper.getInstance(this);
		setTheme("contacts");
		if (authorized(new String[] { "ROLE_USER", "ROLE_ADMIN" })) {
			initAuthorizedUser();
		} else {
			initUnauthorizedUser();
		}
	}

	public void initUnauthorizedUser() {
		if (mainWindow != null && this.getWindows().contains(mainWindow)) {
			removeWindow(mainWindow);
			mainWindow = null;
		}

		loginWindow = new LoginWindow("LoginWindow");
		setMainWindow(loginWindow);

		loginWindow.windowClosedListener = new Action.Listener() {
			public void handleAction(Object o, Object o1) {
				authenticateUser();
			}
		};
	}

	public void initAuthorizedUser() {
		if (loginWindow != null && this.getWindows().contains(loginWindow))
			removeWindow(loginWindow);

		mainWindow = new Window("MyApplication");
		
		setMainWindow(mainWindow);

		function = menubar.addItem("Function", null);
		menubar.setSizeFull();
		function.addItem("Calculate", new CalculateCommand());
		function.addItem("Scoring Rule", new LoadingScoringRuleCommand());

		report = menubar.addItem("Reports", null);
		report.addItem("Scoring Rule Export", new ScoringRuleExportCommand());

		system = menubar.addItem("System", null);
		system.addItem("Logout", new LogOutCommand());
		mainWindow.addComponent(menubar);

	}

	
	public boolean authorized(String... roles) {
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		if (authentication != null
				&& authentication.getAuthorities().size() > 0
				&& (authentication.getAuthorities().toArray()[0]
						.equals("ROLE_USER") || authentication.getAuthorities()
						.toArray()[0].equals("ROLE_ADMIN")))
			return true;
		
		return false;
	}

	public void destroyVaadinApp() {
		logger.info("Destroy Vaadin application............");
	}

	/*
	 * public void setReportManager(ReportManager reportManager) {
	 * this.reportManager = reportManager; }
	 */
	public void downloadReport(File file, final String attachmentName) {
		DownloadableFileStream downloadableFileStream = new DownloadableFileStream(
				file, attachmentName, this);
		downloadableFileStream.setCacheTime(5000); // no cache (<=0) does not
													// work with IE8, (in
													// milliseconds)
		mainWindow.open(downloadableFileStream);
	}
	
	private void removeCuurentChildWindow(){
		this.mainWindow.removeWindow(this.currentChildWindow);
	}

	private class LogOutCommand implements Command {

		public void menuSelected(MenuItem selectedItem) {
			SecurityContextHolder.getContext().setAuthentication(null);
			WebApplicationContext webCtx = (WebApplicationContext) getMainWindow()
					.getApplication().getContext();
			HttpSession session = webCtx.getHttpSession();
			session.invalidate();
			getMainWindow().getApplication().close();
			authenticateUser();
		}

	}

	private class ScoringRuleExportCommand implements Command {

		public void menuSelected(MenuItem selectedItem) {
		
			ReportManager reportManager = (ReportManager) SpringContextHelper
					.getInstance().getBean("reportManager");
			File report = reportManager.generateUsersReport();
			downloadReport(report, "report.xls");

		}

	}

	private class CalculateCommand implements Command {

		public void menuSelected(MenuItem selectedItem) {
			removeCuurentChildWindow();
			CalcWindow calcWindow = (CalcWindow) SpringContextHelper.getInstance().getBean("calcWindow");
			currentChildWindow = calcWindow;
			mainWindow.addWindow(currentChildWindow);
		}

	}

	private class LoadingScoringRuleCommand implements Command {

		public void menuSelected(MenuItem selectedItem) {
			removeCuurentChildWindow();
			ScoringRuleWindow scoringRuleWindow = (ScoringRuleWindow) SpringContextHelper
					.getInstance().getBean("scoringRuleWindow");
			currentChildWindow = scoringRuleWindow;
			mainWindow.addWindow(currentChildWindow);

		}

	}
}