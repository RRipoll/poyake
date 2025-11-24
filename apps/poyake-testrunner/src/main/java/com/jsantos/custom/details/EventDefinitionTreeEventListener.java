package com.jsantos.custom.details;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Treeitem;

import com.jsantos.factory.DTOFactory;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.objectselector.foldertree.DefaultTreeEventListener;
import com.jsantos.gui.objectselector.foldertree.TreeController;
import com.jsantos.gui.objectselector.foldertree.TreeHelper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ConstraintsException;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class EventDefinitionTreeEventListener extends DefaultTreeEventListener{

	public EventDefinitionTreeEventListener(TreeController treeController) {
		super(treeController);
	}
	
	@Override
	public void onDetail(Event event) {
		if (!PermissionFactory.getProvider().hasAnyPermission(tree.getPermissionValue()))
			return;
		try {
			IDetachedRecord dr = (IDetachedRecord) event.getTarget().getAttribute("folder");
			MTField itemField = TreeHelper.getItemField(dr.getTable());
			MTTable tTable = tree.getMtTable();

			if (null != dr.get(itemField)) {
				tTable = itemField.getForeignKey();
				dr = DTOFactory.get(tTable).findByPk(dr.get(itemField));
			
				Events.sendEvent(CustomEvents.ON_ROWCLICK,tree.getTopParent(),dr);
			
			}else {
				Treeitem treeItem=    (Treeitem) event.getTarget().getAttribute("treeItem");
				treeItem.setOpen(!treeItem.isOpen());
			}
			
		} catch (Throwable ex) {
			if ((ex instanceof ConstraintsException))
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null,
						2000);
			else
				throw ex;
		}
	}
}
