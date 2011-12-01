package com.bpc.ui;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

import com.bpc.model.ScoringRule;
import com.bpc.ui.forms.FormPojoExample;
import com.bpc.ui.forms.FormWindow;
import com.bpc.utils.ScoringRuleController;
import com.vaadin.data.Property;

import com.vaadin.ui.Button;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;

@Component("scoringRuleWindow")
@Scope("request")
public class ScoringRuleWindow extends Window {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ScoringRuleTable scoringRuleTable;
	@Autowired
	private ScoringRuleController scoringRuleController;
	@Autowired
	private TabSheetScoringRule tabSheetScoringRule;
	private Button add;
	private Button edit;
	private Button loadingScoringRule;

	@PostConstruct
	public void init() {
		setCaption("Scoring Rule Window");
		setSizeFull();
		setPositionX(0);
		setPositionY(0);
		loadingScoringRule = new Button("Loading Scoring Rules");
		loadingScoringRule.addListener(new LoadingScoringRuleListner());
		addComponent(loadingScoringRule);
		addComponent(scoringRuleTable);

		add = new Button("Add");
		add.addListener(new AddListener());
		edit = new Button("Edit");
		edit.setEnabled(false);

		addComponent(add);
		addComponent(edit);
		addComponent(tabSheetScoringRule);
		addListener(new Window.CloseListener() {
			public void windowClose(CloseEvent e) {

			}

		});

		scoringRuleTable.getTable().addListener(new TableListener());
	}

	private class AddListener implements Button.ClickListener {

		public void buttonClick(ClickEvent event) {
			FormWindow formWindow = new FormWindow();
			getParent().addWindow(formWindow);
		}

	}

	private class LoadingScoringRuleListner implements Button.ClickListener {

		public void buttonClick(ClickEvent event) {
			scoringRuleTable.getTable().setContainerDataSource(
					scoringRuleController.getScoringRuleBeanItemContainer());
			scoringRuleTable.setTableStyte();

		}

	}

	private class TableListener implements Table.ValueChangeListener {

		public void valueChange(Property.ValueChangeEvent event) {
			// in multiselect mode, a Set of itemIds is returned,
			// in singleselect mode the itemId is returned directly
			// Set<?> value = (Set<?>) event.getProperty().getValue();
			ScoringRule scoringRule = (ScoringRule) event.getProperty()
					.getValue();
			// if (null == user || value.size() == 0) {
			if (null == scoringRule) {
				edit.setEnabled(true);
			} else {
				// selected.setValue("Selected: " + scoringRule.toString());
				addComponent(tabSheetScoringRule);
				tabSheetScoringRule.getRuleCaseTable().setTableDataSources(
						scoringRuleController
								.getRuleCaseBeanItemContainer(scoringRule));
				tabSheetScoringRule.getMappingRuleTable().setTableDataSources(
						scoringRuleController
								.getMappingRuleBeanItemContainer(scoringRule));
			}
		}

	}

}
