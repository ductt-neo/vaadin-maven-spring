package com.bpc.ui;

import com.bpc.model.ScoringRule;
import com.bpc.model.User;
import com.bpc.ui.forms.FormWindow;
import com.bpc.utils.ClassFieldNameUtils;
import com.bpc.utils.FieldNameUtils;
import com.bpc.utils.ScoringRuleController;
import com.bpc.utils.UserController;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA. User: do_th Date: 11/18/11 Time: 4:26 PM To change
 * this template use File | Settings | File Templates.
 */
public class ScoringRuleTable extends VerticalLayout{
	
	private Table table;	
	public ScoringRuleTable() {
		
		table = new Table("Scoring Rules Table");		
		addComponent(table);		
		table.setContainerDataSource(new BeanItemContainer<ScoringRule>(
				ScoringRule.class, new ArrayList<ScoringRule>()));
		// set column headers
		setTableStyte();
	}

	public void setTableStyte() {
		// size
		table.setWidth("100%");
		table.setHeight("170px");
		// selectable
		table.setSelectable(true);
		table.setMultiSelect(false);
		table.setImmediate(true); // react at once when something is selected

		// turn on column reordering and collapsing
		table.setColumnReorderingAllowed(true);
		table.setColumnCollapsingAllowed(true);
		String[] columns = FieldNameUtils.scoringRuleFieldName;
		table.setVisibleColumns(columns);
		table.setColumnHeaders(columns);
		// Column alignment
		for (int i = 0; i < columns.length; i++) {
			table.setColumnAlignment(columns[i], Table.ALIGN_LEFT);
		}
	}
	
	public Table getTable() {
		return table;
	}
		
}
