package com.bpc.ui;

import java.util.ArrayList;

import com.bpc.example.ui.component.ScoringRuleForm;
import com.bpc.example.ui.enu.FormStatusEnum;
import com.bpc.model.ScoringRule;
import com.bpc.utils.FieldNameUtils;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.NestedMethodProperty;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.BaseTheme;

/**
 * Created by IntelliJ IDEA. User: do_th Date: 11/18/11 Time: 4:26 PM To change
 * this template use File | Settings | File Templates.
 */
public class ScoringRuleTable extends VerticalLayout {

   private Table table;
   private ScoringRuleForm scoringRuleForm;

   public ScoringRuleTable() {
      table = new Table("Scoring Rules Table");
      addComponent(table);
      table.setContainerDataSource(new BeanItemContainer<ScoringRule>(ScoringRule.class, new ArrayList<ScoringRule>()));
      initActionButtons();

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

   public void setScoringRuleForm(ScoringRuleForm scoringRuleForm) {
      this.scoringRuleForm = scoringRuleForm;
   }

   private void initActionButtons() {
      HorizontalLayout actionButtonsLayout = new HorizontalLayout();
      actionButtonsLayout.setSpacing(true);

      Button addNewButton = new Button("Add new", this, "handleAddNewButtonClick");
      actionButtonsLayout.addComponent(addNewButton);

      Button editButton = new Button("Edit selected item", this, "handleEditButtonClick");
      editButton.setStyleName(BaseTheme.BUTTON_LINK);
      actionButtonsLayout.addComponent(editButton);

      addComponent(actionButtonsLayout);
   }

   public void handleEditButtonClick(ClickEvent event) {
      ScoringRule value = (ScoringRule) table.getValue();
      BeanItem<ScoringRule> bean = new BeanItem<ScoringRule>(value);
      bean.addItemProperty("factorname", new NestedMethodProperty(value, "factor.name"));
      scoringRuleForm.setStatus(FormStatusEnum.EDIT);
      scoringRuleForm.setItemDataSource(bean);
      popupScoringRuleForm();
   }

   public void handleAddNewButtonClick(ClickEvent event) {
      BeanItem<ScoringRule> bean = new BeanItem<ScoringRule>(new ScoringRule());
      scoringRuleForm.setStatus(FormStatusEnum.ADD);
      scoringRuleForm.setItemDataSource(bean);
      popupScoringRuleForm();
   }

   private void popupScoringRuleForm() {
      Window scoringRulePopupWindow = new Window();
      scoringRulePopupWindow.setWidth("70%");
      scoringRulePopupWindow.setHeight("50%");
      scoringRulePopupWindow.center();
      scoringRulePopupWindow.addComponent(scoringRuleForm);
      getApplication().getMainWindow().addWindow(scoringRulePopupWindow);
   }

}
