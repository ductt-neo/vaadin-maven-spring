package com.bpc.ui;


import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringUser;
import com.bpc.utils.*;
import com.bpc.vaadin.component.ScoringUserFieldFactory;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.Action;
import com.vaadin.terminal.Paintable;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.BaseTheme;
import org.hibernate.cfg.Settings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/18/11
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoringUserDetailWindow extends Window {

    private ScoringUser user;
    private UserManageController userManageController;

    public ScoringUserDetailWindow(ScoringUser bindedUser, final String operation) {
        super("User Detail");

        userManageController = (UserManageController) SpringContextHelper.getInstance().getBean("userManageController");
        user = bindedUser==null?new ScoringUser():bindedUser;

        this.setModal(true);

        BeanItem<ScoringUser> bindingUser = new BeanItem<ScoringUser>(user);
        final Form userForm = buildFormGui(bindingUser);

        addComponent(userForm);

        /*Settings Buttons*/
        HorizontalLayout buttonPanel = new HorizontalLayout();
        buttonPanel.setSpacing(true);

        Button apply = new Button("Save", new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                userForm.commit();
                if (operation.equals(ScoringConstants.SCORING_USER_OPERATION_C)) {
                    createUser();
                    closeWindow();
                } else if (operation.equals(ScoringConstants.SCORING_USER_OPERATION_U)) {
                    updateUser();
                    closeWindow();
                }
            }
        });
        buttonPanel.addComponent(apply);
        buttonPanel.setComponentAlignment(apply, Alignment.MIDDLE_RIGHT);

        Button delete = new Button("Delete", new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                deleteUser();
                closeWindow();
            }
        });
        buttonPanel.addComponent(delete);
        buttonPanel.setComponentAlignment(delete, Alignment.MIDDLE_RIGHT);

        Button discardChanges = new Button("Cancel", new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                userForm.discard();
                closeWindow();
            }
        });

//        discardChanges.setStyleName(BaseTheme.BUTTON_LINK);
        buttonPanel.addComponent(discardChanges);
        buttonPanel.setComponentAlignment(discardChanges, Alignment.MIDDLE_RIGHT);

        userForm.getFooter().addComponent(buttonPanel);
        userForm.getFooter().setMargin(false, false, true, true);
    }

    private Form buildFormGui(BeanItem<ScoringUser> bindingUser){
        Form userForm = new Form();

        //GridLayout layout = new GridLayout(4, 2);
        /*layout.setMargin(true, false, false, true);
        layout.setSpacing(true);*/

//        userForm.setLayout(layout);
        /*userForm.setCaption("User details");*/
        userForm.setWriteThrough(false); // we want explicit 'apply'
        userForm.setInvalidCommitted(false); // no invalid values in datamodel

        // FieldFactory for customizing the fields and adding validators
        userForm.setFormFieldFactory(new ScoringUserFieldFactory());
        userForm.setItemDataSource(bindingUser); // bind to POJO via BeanItem

        userForm.setVisibleItemProperties(Arrays.asList(new String[]{"userName", "newPassword", "repeatedNewPassword", "enabled", "stringAuthorities"}));

        return userForm;
    }

    private void createUser(){
        try {
            userManageController.createScoringUser(user);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void updateUser(){
        try {
            userManageController.updateScoringUser(user);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void deleteUser(){
        try {
            userManageController.deleteScoringUser(user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void closeWindow(){
        getParent().removeWindow(this);
    }

}

