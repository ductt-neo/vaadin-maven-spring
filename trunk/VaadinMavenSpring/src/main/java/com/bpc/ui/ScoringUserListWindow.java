package com.bpc.ui;


import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringUser;
import com.bpc.utils.*;
import com.vaadin.data.Container;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.MouseEvents;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.persistence.Column;
import javax.swing.table.TableColumn;
import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/18/11
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
//@Component
//@Scope("request")
public class ScoringUserListWindow extends Window {

    private UserManageController userManageController;
    private Table userListTable;

    public ScoringUserListWindow() {
        super("Scoring User List");
        this.setWidth("100%");
        this.setHeight("100%");

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.setMargin(true); // we want a margin
        verticalLayout.setSpacing(true); // and spacing between components

        userListTable = new Table("");
        userListTable.addListener(new ItemClickEvent.ItemClickListener() {
            public void itemClick(ItemClickEvent itemClickEvent) {
                if(itemClickEvent.isDoubleClick()){
                    ScoringUser selectedUser = (ScoringUser)itemClickEvent.getItemId();
                    /*getWindow().showNotification(new Notification("test"));*/
                    /*show user form detail*/
                    openDetailForUpdate(selectedUser);
                }
            }
        });
        initUserTableList();

        verticalLayout.addComponent(userListTable);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setMargin(true); // we want a margin
        horizontalLayout.setSpacing(true); // and spacing between components

        Button btnAddNew = new Button("New User");
        horizontalLayout.addComponent(btnAddNew);
        btnAddNew.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent clickEvent) {
                openDetailForCreate();
            }
        });

        Button btnRefresh = new Button("Refresh");
        horizontalLayout.addComponent(btnRefresh);
        btnRefresh.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent clickEvent) {
                initUserTableList();
            }
        });

        verticalLayout.addComponent(horizontalLayout);
        addComponent(verticalLayout);

        addListener(new Window.CloseListener() {
            // inline close-listener
            public void windowClose(CloseEvent e) {
            }
        });

    }

    private void initUserTableList() {

        // size
        userListTable.setWidth("100%");
        userListTable.setHeight("100%");

        // selectable
        userListTable.setSelectable(true);
        userListTable.setMultiSelect(false);
        userListTable.setImmediate(true); // react at once when something is selected

        // turn on column reordering and collapsing
        userListTable.setColumnReorderingAllowed(true);
        userListTable.setColumnCollapsingAllowed(true);

        TableColumn column = new TableColumn();
        userManageController = (UserManageController)SpringContextHelper.getInstance().getBean("userManageController");
        try {
            userListTable.setContainerDataSource(userManageController.getAllUsers());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        String[] columns = FieldNameUtils.scoringUserFieldName;
        /*userListTable.set*/
        userListTable.setVisibleColumns(new String[]{"userName", "enabled"});
        userListTable.setColumnHeaders(new String[]{"userName", "enabled"});

        // Column alignment
        for (int i = 0; i < columns.length; i++) {
            userListTable.setColumnAlignment(columns[i], Table.ALIGN_LEFT);
        }

    }

    private void openDetailForUpdate(ScoringUser selectedUser){
        final ScoringUserDetailWindow detailWindow = new ScoringUserDetailWindow(selectedUser, ScoringConstants.SCORING_USER_OPERATION_U);
        detailWindow.setWidth("350");
        detailWindow.setHeight("370");
        getParent().addWindow(detailWindow);
        detailWindow.addListener(new Window.CloseListener(){
            public void windowClose(CloseEvent e) {
                getWindow().showNotification(new Notification("Operation completed"));
            }
        });
    }

    private void openDetailForCreate(){
        final ScoringUserDetailWindow detailWindow = new ScoringUserDetailWindow(null, ScoringConstants.SCORING_USER_OPERATION_C);
        detailWindow.setWidth("350");
        detailWindow.setHeight("370");
        getParent().addWindow(detailWindow);
        detailWindow.addListener(new Window.CloseListener(){
            public void windowClose(CloseEvent e) {
                getWindow().showNotification(new Notification("Operation completed"));
            }
        });
    }

}
