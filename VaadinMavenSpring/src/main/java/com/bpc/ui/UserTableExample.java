package com.bpc.ui;

/**
 * Created by IntelliJ IDEA.
 * User: do_th
 * Date: 11/16/11
 * Time: 12:07 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.HashSet;

import com.bpc.model.User;
import com.bpc.utils.UserController;
import com.vaadin.data.Item;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.Action;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.CellStyleGenerator;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class UserTableExample extends VerticalLayout implements
		Button.ClickListener {

	private UserController userController;

	private Table table = new Table("FE Web User Table");

	private HashSet<Object> markedRows = new HashSet<Object>();

	static final Action ACTION_MARK = new Action("Mark");
	static final Action ACTION_UNMARK = new Action("Unmark");
	static final Action ACTION_LOG = new Action("Save");
	static final Action[] ACTIONS_UNMARKED = new Action[] { ACTION_MARK,
			ACTION_LOG };
	static final Action[] ACTIONS_MARKED = new Action[] { ACTION_UNMARK,
			ACTION_LOG };

	public UserTableExample() {
		// setUserController(userController);
		Button button = new Button("Loading User");
		addComponent(button);
		addComponent(table);

		button.addListener(this);
		// Label to indicate current selection
		final Label selected = new Label("No selection");
		addComponent(selected);

		table.setContainerDataSource(new BeanItemContainer<User>(User.class,
				new ArrayList<User>()));
		// table.setVisibleColumns(new String[] { "PersionId", "Login", "Name"
		// });
		// set column headers
		setTableStyte();
		// Actions (a.k.a context menu)

		table.addActionHandler(new Action.Handler() {
			public Action[] getActions(Object target, Object sender) {
				if (markedRows.contains(target)) {
					return ACTIONS_MARKED;
				} else {
					return ACTIONS_UNMARKED;
				}
			}

			public void handleAction(Action action, Object sender, Object target) {
				if (ACTION_MARK == action) {
					markedRows.add(target);
					// table.refreshRowCache();
				} else if (ACTION_UNMARK == action) {
					markedRows.remove(target);
					// table.refreshRowCache();
				} else if (ACTION_LOG == action) {
					Item item = table.getItem(target);
					addComponent(new Label("Saved: "
							+ target
							+ ", "
							+ item.getItemProperty(
									UserController.USER_PROPERTIES_PERSONID)
									.getValue()));
				}

			}

		});

		// style generator
		table.setCellStyleGenerator(new CellStyleGenerator() {
			public String getStyle(Object itemId, Object propertyId) {
				if (propertyId == null) {
					// no propertyId, styling row
					return (markedRows.contains(itemId) ? "marked" : null);
				} else if (UserController.USER_PROPERTIES_PERSONID
						.equals(propertyId)) {
					return "bold";
				} else {
					// no style
					return null;
				}

			}

		});

		// listen for valueChange, a.k.a 'select' and update the label
		table.addListener(new Table.ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				// in multiselect mode, a Set of itemIds is returned,
				// in singleselect mode the itemId is returned directly
				// Set<?> value = (Set<?>) event.getProperty().getValue();
				User user = (User) event.getProperty().getValue();
				// if (null == user || value.size() == 0) {
				if (null == user) {
					selected.setValue("No selection");
				} else {
					selected.setValue("Selected: " + user.toString());
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
		table.setVisibleColumns(new String[] { "personId", "login", "name" });
		table.setColumnHeaders(new String[] { "PersonId", "Login", "Name" });

		// Column alignment
		table.setColumnAlignment(UserController.USER_PROPERTIES_PERSONID,
				Table.ALIGN_LEFT);
		table.setColumnAlignment(UserController.USER_PROPERTIES_LOGIN,
				Table.ALIGN_LEFT);
		table.setColumnAlignment(UserController.USER_PROPERTIES_NAME,
				Table.ALIGN_LEFT);
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public Table getTable() {
		return table;
	}

	public void buttonClick(Button.ClickEvent clickEvent) {
		table.setContainerDataSource(userController.getUsersBeanItemContainer());
		setTableStyte();
	}
}
