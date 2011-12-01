package com.bpc.ui.forms;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.vaadin.data.Item;
import com.vaadin.data.Validator;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.validator.StringLengthValidator;
import com.bpc.model.ScoringRule;
import com.bpc.model.ScoringRuleCase;
import com.bpc.utils.ExampleUtil;
import com.bpc.utils.ScoringRuleController;
import com.bpc.utils.SpringContextHelper;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.BaseTheme;


public class FormPojoExample extends VerticalLayout {
	
	private ScoringRuleController scoringRuleController;
	// the 'POJO' we're editing
	private ScoringRuleCase scoringRuleCase;

	private static final String COMMON_FIELD_WIDTH = "12em";

	public FormPojoExample() {

		scoringRuleCase = new ScoringRuleCase(); // a person POJO
		BeanItem<ScoringRuleCase> personItem = new BeanItem<ScoringRuleCase>(
				scoringRuleCase); // item from
		// POJO

		// Create the Form
		final Form personForm = new Form();
		personForm.setCaption("Scoring Rule Case");
		personForm.setWriteThrough(false); // we want explicit 'apply'
		personForm.setInvalidCommitted(false); // no invalid values in datamodel

		// FieldFactory for customizing the fields and adding validators
		personForm.setFormFieldFactory(new PersonFieldFactory());
		personForm.setItemDataSource(personItem); // bind to POJO via BeanItem

		// Determines which properties are shown, and in which order:
		personForm.setVisibleItemProperties(Arrays.asList(new String[] {
				"factorChoice", "score", "rule" }));

		// Add form to layout
		addComponent(personForm);

		// The cancel / apply buttons
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.setSpacing(true);
		Button discardChanges = new Button("Discard changes",
				new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						personForm.discard();
					}
				});
		discardChanges.setStyleName(BaseTheme.BUTTON_LINK);
		buttons.addComponent(discardChanges);
		buttons.setComponentAlignment(discardChanges, Alignment.MIDDLE_LEFT);

		Button apply = new Button("Save", new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				try {
					personForm.commit();
				} catch (Exception e) {
					// Ignored, we'll let the Form handle the errors
				}
			}
		});
		buttons.addComponent(apply);
		personForm.getFooter().addComponent(buttons);
		personForm.getFooter().setMargin(false, false, true, true);

		// button for showing the internal state of the POJO
		Button showPojoState = new Button("Show POJO internal state",
				new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						showPojoState();
					}
				});
		addComponent(showPojoState);
	}

	private void showPojoState() {
		Window.Notification n = new Window.Notification("POJO state",
				Window.Notification.TYPE_TRAY_NOTIFICATION);
		n.setPosition(Window.Notification.POSITION_CENTERED);
		n.setDescription("Factor Choice: " + scoringRuleCase.getFactorChoice()
				+ "<br/>Score: " + scoringRuleCase.getScore() + "<br/>Rule: "
				+ scoringRuleCase.getRule().getScheme());
		getWindow().showNotification(n);
	}

	private class PersonFieldFactory extends DefaultFieldFactory {

		ComboBox scoringRule = new ComboBox("Scoring Rule");

		public PersonFieldFactory() {

			// scoringRule = new ComboBox("Country");
			scoringRuleController = (ScoringRuleController)SpringContextHelper.getInstance().getBean("scoringRuleController");
			BeanItemContainer<ScoringRule> beanItemContainer = scoringRuleController
					.getScoringRuleBeanItemContainer();

			scoringRule.setContainerDataSource(beanItemContainer);
			scoringRule.setNullSelectionAllowed(false);
			
			// countries.setItemCaptionPropertyId("value");
			//scoringRule.setValue(beanItemContainer.getItemIds().iterator().next());
			scoringRule.setImmediate(true);
		}

		@Override
		public Field createField(Item item, Object propertyId,
				Component uiContext) {
			Field f;
			if ("rule".equals(propertyId)) {
				// filtering ComboBox w/ country names
				return scoringRule;

			} else {
				// Use the super class to create a suitable field base on the
				// property type.
				f = super.createField(item, propertyId, uiContext);
			}

			if ("factorChoice".equals(propertyId)) {
				TextField tf = (TextField) f;
				tf.setRequired(true);
				tf.setRequiredError("Please enter a Factor Choice");
				tf.setWidth(COMMON_FIELD_WIDTH);
				tf.addValidator(new StringLengthValidator(
						"First Name must be 3-25 characters", 3, 25, false));
			}
			if ("score".equals(propertyId)) {
				TextField tf = (TextField) f;
				tf.setNullRepresentation("");
				tf.setNullSettingAllowed(true);
				tf.setRequired(true);
				tf.addValidator(new NumberValidator(
						"Shoe size must be an Number"));
				tf.setWidth("10em");
			}

			return f;
		}

		private PasswordField createPasswordField(Object propertyId) {
			PasswordField pf = new PasswordField();
			pf.setCaption(DefaultFieldFactory
					.createCaptionByPropertyId(propertyId));
			return pf;
		}
	}

	public class NumberValidator implements Validator {

		private String message;

		public NumberValidator(String message) {
			this.message = message;
		}

		public boolean isValid(Object value) {
			if (value == null || !(value instanceof String)) {
				return false;
			}
			try {
				Double.parseDouble((String) value);
			} catch (Exception e) {
				return false;
			}
			return true;
		}

		public void validate(Object value) throws InvalidValueException {
			if (!isValid(value)) {
				throw new InvalidValueException(message);
			}
		}

	}

}
