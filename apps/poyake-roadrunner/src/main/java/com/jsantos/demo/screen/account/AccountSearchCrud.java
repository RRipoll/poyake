package com.jsantos.demo.screen.account;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;

import com.jsantos.gui.form.CrudScreen;
import com.jsantos.orm.exceptions.ConstraintsException;

public class AccountSearchCrud extends CrudScreen {

	private static final long serialVersionUID = 1L;

	@Override
	protected void newItem(Event evt) {
		try {
			((Window) new CreateAccountCrud().buildEditorScreen(getParent(), true)).doModal();
			filteredGrid.getEntityGrid().buildGrid();
		} catch (Throwable ex) {
			if ((ex instanceof ConstraintsException))
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null, 2000);
		}
	}
}
