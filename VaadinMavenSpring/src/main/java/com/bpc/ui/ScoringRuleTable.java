package com.bpc.ui;


import com.bpc.model.ScoringRule;
import com.bpc.model.User;
import com.bpc.utils.ClassFieldNameUtils;
import com.bpc.utils.ScoringRuleController;
import com.bpc.utils.UserController;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/18/11
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoringRuleTable extends VerticalLayout implements Button.ClickListener {

    private ScoringRuleController scoringRuleController;
    private Table table;
    private TabSheetScoringRule tabSheetScoringRule;

    public ScoringRuleTable() {
        table = new Table("Scoring Rules Table");
        Button button = new Button("Loading User");
        addComponent(button);
        addComponent(table);

        button.addListener(this);
        // Label to indicate current selection
        final Label selected = new Label("No selection");
        addComponent(selected);
        table.setContainerDataSource(
                new BeanItemContainer<ScoringRule>(ScoringRule.class, new ArrayList<ScoringRule>()));

        // set column headers
        setTableStyte();
        // listen for valueChange, a.k.a 'select' and update the label
        table.addListener(new Table.ValueChangeListener() {
            public void valueChange(Property.ValueChangeEvent event) {
                // in multiselect mode, a Set of itemIds is returned,
                // in singleselect mode the itemId is returned directly
                //Set<?> value = (Set<?>) event.getProperty().getValue();
                ScoringRule scoringRule = (ScoringRule) event.getProperty().getValue();
                // if (null == user || value.size() == 0) {
                if (null == scoringRule) {
                    selected.setValue("No selection");
                } else {
                    selected.setValue("Selected: " + scoringRule.toString());
                    addComponent(tabSheetScoringRule);
                    tabSheetScoringRule.getRuleCaseTable().
                            setTableDataSources(scoringRuleController.getRuleCaseBeanItemContainer(scoringRule));
                }
            }
        });

    }


    public void buttonClick(Button.ClickEvent clickEvent) {
        table.setContainerDataSource(scoringRuleController.getScoringRuleBeanItemContainer());
        setTableStyte();
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
        String[] columns = ClassFieldNameUtils.getFieldNames(ScoringRule.class);
        table.setVisibleColumns(columns);
        table.setColumnHeaders(columns);

        // Column alignment

        for (int i = 0; i < columns.length; i++) {
            table.setColumnAlignment(columns[i], Table.ALIGN_LEFT);
        }

    }

    public void setScoringRuleController(ScoringRuleController scoringRuleController) {
        this.scoringRuleController = scoringRuleController;
    }

    public void setTabSheetScoringRule(TabSheetScoringRule tabSheetScoringRule) {
        this.tabSheetScoringRule = tabSheetScoringRule;
    }
}
