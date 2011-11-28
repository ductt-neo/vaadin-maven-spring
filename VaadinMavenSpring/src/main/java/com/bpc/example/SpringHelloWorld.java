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
import com.bpc.ui.LoginWindow;
import com.bpc.ui.ScoringRuleTable;
import com.bpc.utils.SpringContextHelper;
import com.vaadin.event.Action;
import com.vaadin.terminal.gwt.server.WebApplicationContext;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * @author do_th
 */
// @Configurable(preConstruction = true)
public class SpringHelloWorld extends com.vaadin.Application implements
      Button.ClickListener {
   private static final Logger logger = Logger
         .getLogger(SpringHelloWorld.class);
   // @Autowired
   // private CalculateServices bean;
   private CalcWindow calcdWin;
   private Window mainWindow;
   private ScoringRuleTable scoringRuleTable;
   private LoginWindow loginWindow;

   private Button generateExampleReport = new Button("Export report");

   private ReportManager reportManager;

   // @Override
   public void init() {
      authenticateUser();
   }

   public void authenticateUser() {
      SpringContextHelper.getInstance(this);
      setTheme("contacts");
      if (authorized("ROLE_USER")) {
         initAuthorizedUser();
      }
      else {
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
      Label label = new Label("Hello Vaadin user");
      // mainWindow.addComponent(label);
      setMainWindow(mainWindow);

      // SET LOGOUT BUTTON
      Button btnLogout = new Button("Logout");
      btnLogout.addListener(new Button.ClickListener() {
         public void buttonClick(ClickEvent clickEvent) {
            SecurityContextHolder.getContext().setAuthentication(null);
            WebApplicationContext webCtx = (WebApplicationContext) getMainWindow()
                  .getApplication().getContext();
            HttpSession session = webCtx.getHttpSession();
            session.invalidate();
            getMainWindow().getApplication().close();
            authenticateUser();
         }
      });
      // mainWindow.addComponent(btnLogout);

      Button button = new Button("Add Calculation Window");
      button.addListener(this);
      mainWindow.addComponent(button);

      generateExampleReport.addListener(this);
      mainWindow.addComponent(generateExampleReport);

      // TreeTableBasicExample treeTableBasicExample = new
      // TreeTableBasicExample();
      // UserTableExample userTableExample = new UserTableExample();
      // mainWindow.addComponent(treeTableBasicExample);
      mainWindow.addComponent(scoringRuleTable);
      // mainWindow.addComponent(tabSheetScoringRule);
      // calcdWin = new CalcWindow("Child Window");

   }

   public void buttonClick(ClickEvent event) {
      if (calcdWin.getParent() != null) {
         // window is already showing
         mainWindow.removeWindow(calcdWin);

      }
      else if (generateExampleReport == event.getButton()) {
         File report = reportManager.generateUsersReport();
         downloadReport(report, "report.xls");
      }
      else {
         mainWindow.addWindow(calcdWin);
      }
   }

   public void setScoringRuleTable(ScoringRuleTable scoringRuleTable) {
      this.scoringRuleTable = scoringRuleTable;
   }

   public void setCalcdWin(CalcWindow calcdWin) {
      this.calcdWin = calcdWin;
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
      /*
       * Collection<GrantedAuthority> authorities =
       * authentication.getAuthorities(); for(GrantedAuthority authority:
       * authorities){ for(String role: roles){
       * if(role.equals(authority.getAuthority())){ return true; } } }
       */
      return false;
   }

   public void destroyVaadinApp() {
      logger.info("Destroy Vaadin application............");
   }

   public void setReportManager(ReportManager reportManager) {
      this.reportManager = reportManager;
   }

   public void downloadReport(File file, final String attachmentName) {
      DownloadableFileStream downloadableFileStream = new DownloadableFileStream(file, attachmentName, this);
      downloadableFileStream.setCacheTime(5000); // no cache (<=0) does not work with IE8, (in milliseconds)
      mainWindow.open(downloadableFileStream);
   }
}