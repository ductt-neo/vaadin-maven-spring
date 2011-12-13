package com.bpc.vaadin.component;

import com.bpc.model.ScoringUser;
import com.bpc.model.ScoringUserRole;
import com.bpc.utils.SpringContextHelper;
import com.bpc.utils.UserManageController;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.*;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Bui_qt
 * Date: 11/29/11
 * Time: 5:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoringUserFieldFactory extends DefaultFieldFactory {


    private UserManageController userManageController;

    public ScoringUserFieldFactory() {
        userManageController = (UserManageController) SpringContextHelper.getInstance().getBean("userManageController");
    }



    @Override
    public Field createField(Item item, Object propertyId, Component uiContext) {
        Field f;
        if ("stringAuthorities".equals(propertyId)) {
            //filtering ComboBox w/ country names
            f = createAuthority(item, propertyId);
        } else if ("newPassword".equals(propertyId)||"repeatedNewPassword".equals(propertyId)) {
            // Create a password field so the password is not shown
            f = createPasswordField(propertyId);
        } else {
            // Use the super class to create a suitable field base on the
            // property type.
            f = super.createField(item, propertyId, uiContext);
        }

        if ("userName".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setRequired(true);
            tf.setReadOnly(true);
            tf.setRequiredError("Please enter a Name");
            tf.setWidth("150");
            tf.addValidator(new StringLengthValidator(
                    "Name must be 3-25 characters", 3, 25, false));
        } else if ("enabled".equals(propertyId)) {
            TextField tf = (TextField) f;
            tf.setRequired(true);
            tf.setRequiredError("Please enter a enabled");
            tf.setWidth("100");
            tf.addValidator(new StringLengthValidator(
                    "Enable is Y/N", 1, 1, false));
        } else if ("newPassword".equals(propertyId)||"repeatedNewPassword".equals(propertyId)) {
            PasswordField pf = (PasswordField) f;
            /*pf.setRequired(true);
            pf.setRequiredError("Please enter a password");*/
            pf.setWidth("10em");
            /*pf.addValidator(new StringLengthValidator(
                    "Password must be 6-20 characters", 6, 20, false));*/
        } else if ("stringAuthorities".equals(propertyId)) {
            ListSelect pf = (ListSelect) f;
            pf.setRequired(true);
            pf.setRequiredError("Please select authority");
        }
        return f;
    }

    private PasswordField createPasswordField(Object propertyId) {
        PasswordField pf = new PasswordField();
        pf.setCaption(DefaultFieldFactory
                .createCaptionByPropertyId(propertyId));
        return pf;
    }

    private ListSelect createAuthority(Item item, Object propertyId) {
        ListSelect lbxAuthority = new ListSelect("Authorities");
        /*lbxAuthority.set*/
        lbxAuthority.setWidth("150");
        lbxAuthority.setRows(3);
        lbxAuthority.setNullSelectionAllowed(false);
        lbxAuthority.setMultiSelect(true);
        lbxAuthority.setImmediate(true);
//        lbxAuthority.setNewItemsAllowed(true);
        try {

            List<ScoringUserRole> fullRoles = new ArrayList<ScoringUserRole>();
            List<String> authorities = userManageController.getAllAuthorities();
            for(String authority: authorities){
                ScoringUserRole roleItem = new ScoringUserRole();
//                roleItem.setAuthority(authority);
                fullRoles.add(roleItem);
            }


            BeanItemContainer authorityDataList = new BeanItemContainer(ScoringUserRole.class);
//               authorityDataList.setBeanIdProperty("authority");
            authorityDataList.addAll(fullRoles);

            lbxAuthority.setItemCaptionPropertyId("authority");
            lbxAuthority.setContainerDataSource(authorityDataList);

            BeanItem beanItem = new BeanItem(((ScoringUser) (((BeanItem) item).getBean())));  //
            lbxAuthority.setPropertyDataSource(beanItem.getItemProperty("authorities"));   //stringAuthorities

//            lbxAuthority.select(((ScoringUser) (((BeanItem) item).getBean())).getRoles().get(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
//            lbxAuthority.setItemCaptionPropertyId(ExampleUtil.iso3166_PROPERTY_NAME);
//            lbxAuthority.setItemIconPropertyId(ExampleUtil.iso3166_PROPERTY_FLAG);



        /*ScoringUserRole test=new ScoringUserRole();
        test.setAuthority("ROLE_USER");
        *//**lbxAuthority.select(test);

        lbxAuthority.select("ROLE_ADMIN");*//*



//        List<ScoringUserRole> authorities = new ArrayList<ScoringUserRole>();
//        authorities.add(test);
//        ((ScoringUser) (((BeanItem) item).getBean())).setRoles(authorities);


//        ;

        lbxAuthority.setValue(test);
        lbxAuthority.select(test);

        ScoringUserRole item1 =new ScoringUserRole();
        item1.setAuthority("TEST1");
        ScoringUserRole item2 =new ScoringUserRole();
        item2.setAuthority("TEST2");

        lbxAuthority.addItem(item1);
        lbxAuthority.addItem(item2);

        lbxAuthority.setValue(item1);
        lbxAuthority.select(item1);

        lbxAuthority.setValue(test);
        lbxAuthority.setValue(lbxAuthority.getItem(test));

*/


//        lbxAuthority.setValue("ROLE_USER");
        //lbxAuthority.setValue(test.getAuthority());
//        lbxAuthority.setValue(lbxAuthority.getItem("ROLE_USER"));

        /*List<String> authorities = new ArrayList<String>();
        List<ScoringUserRole> userAuthorities = ((ScoringUser) (((BeanItem) item).getBean())).getRoles();
        for (ScoringUserRole authority : userAuthorities) {
//            lbxAuthority.select((authority.getAuthority()));
            authorities.add(authority.getAuthority());
            *//*Item i = lbxAuthority.getItem(authority.getAuthority());
            lbxAuthority.select(i);*//*
        }

        ((ScoringUser) (((BeanItem) item).getBean())).setStringAuthorities(authorities);*/

        /*lbxAuthority.setp*/
        /*for(Object id:lbxAuthority.getItemIds()){
                  String  itemId = (String)id;

        }*/

        return lbxAuthority;
    }

}
