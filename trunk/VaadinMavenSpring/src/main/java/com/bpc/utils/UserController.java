package com.bpc.utils;

import com.bpc.model.User;
import com.bpc.services.UserServices;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.IndexedContainer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/16/11
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
public final class UserController {
    public static final Object USER_PROPERTIES_PERSONID = "personId";
    public static final Object USER_PROPERTIES_LOGIN = "login";
    public static final Object USER_PROPERTIES_NAME = "name";

    private UserServices userServices;

    public IndexedContainer getUsersContainer() {
        try {
            List<User> users = userServices.getAllUser();
            IndexedContainer c = new IndexedContainer();
            c.addContainerProperty(USER_PROPERTIES_PERSONID, Integer.class, null);
            c.addContainerProperty(USER_PROPERTIES_LOGIN, String.class, null);
            c.addContainerProperty(USER_PROPERTIES_NAME, String.class, null);
            for (User user : users) {
                Integer id = user.getPersonId();
                Item item = c.addItem(id);
                item.getItemProperty(USER_PROPERTIES_PERSONID).setValue(user.getPersonId());
                item.getItemProperty(USER_PROPERTIES_LOGIN).setValue(user.getLogin());
                item.getItemProperty(USER_PROPERTIES_NAME).setValue(user.getName());
            }
            return c;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new IndexedContainer();

        }
    }

    public BeanItemContainer getUsersBeanItemContainer() {
        try {
            List<User> users = userServices.getAllUser();
            BeanItemContainer<User> beanItemContainer = new BeanItemContainer<User>(User.class, users);
            beanItemContainer.sort(new Object[]{USER_PROPERTIES_PERSONID}, new boolean[]{true});
            return beanItemContainer;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new BeanItemContainer<User>(User.class, new ArrayList<User>());

        }
    }

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }
}
