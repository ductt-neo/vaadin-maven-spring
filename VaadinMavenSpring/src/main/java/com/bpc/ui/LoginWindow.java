/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bpc.ui;

import com.bpc.services.CalculateServices;
import com.bpc.utils.SpringContextHelper;
import com.vaadin.data.Property;
import com.vaadin.data.validator.DoubleValidator;
import com.vaadin.event.Action;
import com.vaadin.event.ListenerMethod;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.awt.event.ActionListener;

/**
 * @author do_th
 */
public class LoginWindow extends Window {
    private TextField tbxUserName;
    private PasswordField tbxPassword;

    private Button btnLogin;
    private Label lblUserName;
    private Label lblPassword;
    private Label lblMessage;
//    private CalculateServices calculateServices;

    public Action.Listener windowClosedListener;

    public LoginWindow() {
        this("Vaadin Login");
    }

    public LoginWindow(String caption) {
        super(caption);
        lblUserName = new Label("Username : ");
        lblPassword = new Label("Password : ");
        lblMessage = new Label("");

        tbxUserName = new TextField();
        tbxUserName.setWidth("200");

        tbxPassword = new PasswordField();
        tbxPassword.setWidth("200");
        tbxPassword.setImmediate(true);

        btnLogin = new Button("Login");

//        tbxUserName.addValidator(new DoubleValidator("Inter Number Value!"));
//        tbxPassword.addValidator(new DoubleValidator("Inter Number Value!"));

        setSizeFull();
        addComponent(lblUserName);
        addComponent(tbxUserName);

        addComponent(lblPassword);
        addComponent(tbxPassword);

        addComponent(lblMessage);
        addComponent(btnLogin);

        /*tbxPassword.addListener(new Key);*/
        tbxPassword.addListener(new Property.ValueChangeListener(){
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                process();
            }
        });

        btnLogin.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent clickEvent) {
                    process();
            }
        });

        /*TableFooterExample tableFooterExample = new TableFooterExample();
        addComponent(tableFooterExample);*/

        /*TableMainFeaturesExample tableMainFeaturesExample = new TableMainFeaturesExample();
        addComponent(tableMainFeaturesExample);*/
        addListener(new CloseListener() {
            // inline close-listener
            public void windowClose(CloseEvent e) {
            }

        });
    }

    private void process(){
        try {
        String username = (String)tbxUserName.getValue();
                    String password =  (String)tbxPassword.getValue();

                    //Authenticate username & password with Spring Security
                    Authentication auth = authenticate(username, password);
                    System.out.println("successful");

                    closeWindow();
            } catch (Exception ex) {
                    ex.printStackTrace();
                    lblMessage.setValue(ex.getMessage());
                }
    }

    /*public CalculateServices getCalculateServices() {
        return calculateServices;
    }

    public void setCalculateServices(CalculateServices calculateServices) {
        this.calculateServices = calculateServices;
    }*/

    public void closeWindow(){
        if(windowClosedListener!=null){
             windowClosedListener.handleAction(this, this);
        }
    }

    public Authentication authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        AuthenticationProvider _authProvider = (AuthenticationProvider)SpringContextHelper.getInstance().getBean("daoAuthenticationProvider");
        Authentication auth = _authProvider.authenticate(token);
        if (null != auth) {
            SecurityContextHolder.getContext().setAuthentication(auth);

//            _eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(auth, this.getClass()));

            return auth;
        }
        throw new BadCredentialsException("null authentication");
    }

}
