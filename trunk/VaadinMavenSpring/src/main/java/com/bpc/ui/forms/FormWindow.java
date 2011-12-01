package com.bpc.ui.forms;

import com.vaadin.ui.Window;

public class FormWindow extends Window{
	
	private FormPojoExample formPojoExample;
	
	public FormWindow(){
		super("Person Form Window");
		setModal(true);
		setPositionX(100);
		setPositionX(100);
		setHeight(400);
		setWidth(400);
		formPojoExample = new FormPojoExample();
		addComponent(formPojoExample);
	}

}
