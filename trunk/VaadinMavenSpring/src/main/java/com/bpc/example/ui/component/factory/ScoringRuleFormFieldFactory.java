package com.bpc.example.ui.component.factory;

import com.bpc.utils.ScoringRuleController;
import com.vaadin.data.Item;
import com.vaadin.data.util.MethodProperty;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;

public class ScoringRuleFormFieldFactory extends DefaultFieldFactory {

   private static final long serialVersionUID = -5795752045505501216L;

   private static final String COMMON_FIELD_WIDTH = "12em";

   private ScoringRuleController controller;

   private ComboBox factorsCombobox;

   private ComboBox schemes;

   public Field createField(Item item, Object propertyId, Component uiContext) {
      Field instanceField = null;

      if ("weight".equals(propertyId)) {
         instanceField = super.createField(item, propertyId, uiContext);
         instanceField.setWidth(COMMON_FIELD_WIDTH);
         instanceField.setCaption("Weight");
      }
      else if ("factor".equals(propertyId)) {
         if (factorsCombobox == null) createFactors();
         instanceField = factorsCombobox;
      }
      else if ("scheme".equals(propertyId)) {
         if (schemes == null) createSchemes();
         instanceField = schemes;
      }

      if (instanceField != null) {
         MethodProperty<?> methodProperty = (MethodProperty<?>) item.getItemProperty(propertyId);
         instanceField.setValue(methodProperty.getValue());
      }
      return instanceField;
   }

   private void createFactors() {
      factorsCombobox = new ComboBox("Factor");
      factorsCombobox.setWidth("100%");
      factorsCombobox.setItemCaptionPropertyId("name");
      factorsCombobox.setContainerDataSource(controller.getFactors());
   }

   private void createSchemes() {
      schemes = new ComboBox("Scheme");
      schemes.setWidth("100%");
      schemes.setContainerDataSource(controller.getSchemes());
      schemes.setItemCaptionPropertyId("name");
   }

   public void setController(ScoringRuleController controller) {
      this.controller = controller;
   }

}
