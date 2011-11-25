/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpc.example;

import com.bpc.ui.*;
import com.bpc.utils.SpringContextHelper;
import com.vaadin.event.Action;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author do_th
 */
//@Configurable(preConstruction = true)
public class SpringHelloWorld extends com.vaadin.Application implements Button.ClickListener {

    //@Autowired
    //private CalculateServices bean;
    private CalcWindow calcdWin;
    private Window mainWindow;
    private ScoringRuleTable scoringRuleTable;
    private LoginWindow loginWindow;

    //@Override
    public void init() {
         authenticateUser();
    }

    public void authenticateUser(){
        SpringContextHelper.getInstance(this);
        if(authorized("ROLE_USER")){
			initAuthorizedUser();
		} else {
			initUnauthorizedUser();
		}
    }

    public void initUnauthorizedUser(){
        if(mainWindow!=null && this.getWindows().contains(mainWindow))
            removeWindow(mainWindow);

        loginWindow = new LoginWindow("LoginWindow");
        setMainWindow(loginWindow);

        loginWindow.windowClosedListener = new Action.Listener() {
            public void handleAction(Object o, Object o1) {
                authenticateUser();
            }
        };
    }

    public void initAuthorizedUser(){
        if(loginWindow!=null && this.getWindows().contains(loginWindow))
            removeWindow(loginWindow);

        mainWindow = new Window("MyApplication");
        Label label = new Label("Hello Vaadin user");
        //mainWindow.addComponent(label);
        setMainWindow(mainWindow);

        //SET LOGOUT BUTTON
        Button btnLogout = new Button("Logout");
        btnLogout.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent clickEvent) {
                SecurityContextHolder.getContext().setAuthentication(null);
                authenticateUser();
            }
        });
        mainWindow.addComponent(btnLogout);

        Button button = new Button("Add Calculation Window");
        button.addListener(this);
        mainWindow.addComponent(button);
        //TreeTableBasicExample treeTableBasicExample = new TreeTableBasicExample();
        //UserTableExample userTableExample = new UserTableExample();
        //mainWindow.addComponent(treeTableBasicExample);
        mainWindow.addComponent(scoringRuleTable);
        //mainWindow.addComponent(tabSheetScoringRule);
        //calcdWin = new CalcWindow("Child Window");


    }

    public void buttonClick(ClickEvent event) {
        if (calcdWin.getParent() != null) {
            // window is already showing
            mainWindow.removeWindow(calcdWin);

        } else {
            mainWindow.addWindow(calcdWin);

        }
    }

    public void setScoringRuleTable(ScoringRuleTable scoringRuleTable) {
        this.scoringRuleTable = scoringRuleTable;
    }

    public void setCalcdWin(CalcWindow calcdWin) {
        this.calcdWin = calcdWin;
    }

    public boolean authorized(String ... roles){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null
                && authentication.getAuthorities().size()>0
                && (authentication.getAuthorities().toArray()[0].equals("ROLE_USER")
                ||authentication.getAuthorities().toArray()[0].equals("ROLE_ADMIN")))
            return true;
		/*Collection<GrantedAuthority> authorities = authentication.getAuthorities();
        for(GrantedAuthority authority: authorities){
			for(String role: roles){
				if(role.equals(authority.getAuthority())){
					return true;
				}
			}
		}*/
		return false;
	}

}