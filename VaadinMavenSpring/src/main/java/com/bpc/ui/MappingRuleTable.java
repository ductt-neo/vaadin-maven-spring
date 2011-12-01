package com.bpc.ui;

import com.bpc.model.MappingRule;
import com.bpc.model.ScoringRuleCase;
import com.bpc.utils.FieldNameUtils;
import com.bpc.utils.ScoringRuleController;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA. User: do_th Date: 11/22/11 Time: 3:31 PM To change
 * this template use File | Settings | File Templates.
 */
public class MappingRuleTable extends VerticalLayout {
	private ScoringRuleController scoringRuleController;
	private Table table;

	public MappingRuleTable() {
		table = new Table("");
		table.setContainerDataSource(new BeanItemContainer<MappingRule>(
				MappingRule.class, new ArrayList<MappingRule>()));
		// set column headers
		setTableStyte();
		addComponent(table);
		final Label selected = new Label("No selection");
		addComponent(selected);
		table.addListener(new Table.ValueChangeListener() {
			public void valueChange(Property.ValueChangeEvent event) {
				// in multiselect mode, a Set of itemIds is returned,
				// in singleselect mode the itemId is returned directly
				// Set<?> value = (Set<?>) event.getProperty().getValue();
				MappingRule mappingRule = (MappingRule) event.getProperty()
						.getValue();
				// if (null == user || value.size() == 0) {
				if (null == mappingRule) {
					selected.setValue("No selection");
				} else {
					selected.setValue("Selected: " + mappingRule.toString());
				}
			}
		});
	}

	private void setTableStyte() {
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

		String[] columns = FieldNameUtils.mappingRuleFieldName;
		table.setVisibleColumns(columns);
		table.setColumnHeaders(columns);

		// Column alignment
		for (int i = 0; i < columns.length; i++) {
			table.setColumnAlignment(columns[i], Table.ALIGN_LEFT);
		}
	}

	public void setScoringRuleController(
			ScoringRuleController scoringRuleController) {
		this.scoringRuleController = scoringRuleController;
	}

	public void setTableDataSources(
			BeanItemContainer<MappingRule> tableDataSources) {
		this.table.setContainerDataSource(tableDataSources);
		setTableStyte();
	}
}
