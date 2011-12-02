package com.bpc.example.ui.component;

import com.bpc.dao.ScoringRuleDao;
import com.bpc.example.ui.enu.FormStatusEnum;
import com.bpc.model.ScoringRule;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.BaseTheme;

public class ScoringRuleForm extends Form {

	private static final long serialVersionUID = -161670637794295178L;

	private GridLayout gridLayout;

	private Button okButton;

	private Button disardButton;

	private ScoringRuleDao scoringRuleDao;

	private FormStatusEnum status;

	public ScoringRuleForm() {
		initLayout();
	}

	private void initLayout() {
		setCaption("ExampleScoring Rule Form");
		setDescription("Please specify the information as bellow");

		HorizontalLayout buttonsLayout = new HorizontalLayout();
		buttonsLayout.setSpacing(true);

		disardButton = new Button("Discard", this, "handleDiscardButtonClick");
		disardButton.setStyleName(BaseTheme.BUTTON_LINK);
		buttonsLayout.addComponent(disardButton);

		okButton = new Button("Save", this, "handleOkButtonClick");
		buttonsLayout.addComponent(okButton);

		gridLayout = new GridLayout(2, 3);
		gridLayout.setMargin(true, false, false, true);
		gridLayout.setSpacing(true);
		gridLayout.addComponent(buttonsLayout, 1, 2);

		setLayout(gridLayout);
	}

	protected void attachField(Object propertyId, Field field) {
		if ("weight".equals(propertyId)) {
			gridLayout.addComponent(field, 0, 0);
		}
		else if ("factor".equals(propertyId)) {
			gridLayout.addComponent(field, 0, 1);
		}
		else if ("scheme".equals(propertyId)) {
			gridLayout.addComponent(field, 1, 1);
		}
	}

	public void handleOkButtonClick(ClickEvent event) {
		switch (status) {
			case ADD:
				addnew();
				break;
			case EDIT:
				editme();
				break;
		}
		closeme();
	}

	private void editme() {
		BeanItem<?> item = (BeanItem<?>) getItemDataSource();
		scoringRuleDao.update((ScoringRule) item.getBean());
	}

	private void addnew() {
		// ScoringRule model = new ScoringRule();
		// Field field = getField("weight");
		// model.setWeight(new BigDecimal((String) field.getValue()));
		//
		// field = getField("factor");
		// Factor factor = (Factor) field.getValue();
		// model.setFactor(factor);
		//
		// field = getField("scheme");
		// model.setScheme((ScoringScheme) field.getValue());
		BeanItem<?> item = (BeanItem<?>) getItemDataSource();
		scoringRuleDao.save((ScoringRule) item.getBean());
	}

	public void handleDiscardButtonClick(ClickEvent event) {
		status = FormStatusEnum.DISCARD;
		closeme();
	}

	private void closeme() {
		Window w = getWindow();
		Window mainWindow = w.getApplication().getMainWindow();
		mainWindow.removeWindow(w);
	}

	public void setScoringRuleDao(ScoringRuleDao scoringRuleDao) {
		this.scoringRuleDao = scoringRuleDao;
	}

	public void setStatus(FormStatusEnum status) {
		this.status = status;
	}

	public FormStatusEnum getStatus() {
		return status;
	}
}