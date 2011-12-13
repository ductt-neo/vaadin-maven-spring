package com.bpc.vaadin.component;

import com.bpc.model.ScoringUser;
import com.vaadin.data.util.BeanItemContainer;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Bui_qt
 * Date: 11/29/11
 * Time: 12:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoringUserContainerItem extends BeanItemContainer<ScoringUser> implements Serializable{
    public ScoringUserContainerItem(Class<? super ScoringUser> type) throws IllegalArgumentException {
        super(type);
    }
}
