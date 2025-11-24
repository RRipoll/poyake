package com.jsantos.gui.objectselector.popup;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.ListValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.datagrid4.GridSelectorType;
import com.jsantos.gui.detail.DetailContainerProvider;
import com.jsantos.gui.filteredgrid.FilteredGrid;
import com.jsantos.gui.zKpermission.Permission;
import com.jsantos.gui.zkutil.ButtonCssClass;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ConstraintsException;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class ObjectSelectorPopup {
	Window window = new Window();
	MTField mtField;
	MTTable mtTable;
	FilteredGrid filteredGrid;
	IDetachedRecordAcceptor detachedRecordAcceptor;
	GridSelectorType selector=GridSelectorType.RADIO;
	boolean isUpdated=false;
	
	public ObjectSelectorPopup (MTField mtField,MTTable mtTable, IDetachedRecordAcceptor detachedRecordAcceptor) {
		this.mtTable=mtTable;
		this.mtField = mtField;
		this.detachedRecordAcceptor = detachedRecordAcceptor;
	}
	
	public void doModal() {

		init();
		window.doModal();
	}
	
	private void init() {
		window.getChildren().clear();
		window.setWidth("80%");
		window.setHeight("80%");
		filteredGrid = new FilteredGrid(mtTable, window);
		filteredGrid.setSelectorType(selector);
		filteredGrid.init();
		if(mtField.getDataType().equals(MTDataTypes.MULTIPLEOBJECT))
			filteredGrid.getEntityGrid().getSelectionMan().getSelectedSet().addAll(MultipleHelper.getLinkDetachedRecord(detachedRecordAcceptor.getDrs(),mtField));
		else filteredGrid.getEntityGrid().getSelectionMan().getSelectedSet().addAll(detachedRecordAcceptor.getDrs());
		filteredGrid.setHeaderLabel(mtTable.getTableName());
		filteredGrid.build();
		
		filteredGrid.addHeaderButton("OBJECTSELECTOR_OK","Ok",ButtonCssClass.COLOR_PRIMARY).addEventListener(Events.ON_CLICK, this::onSaveButton);
		filteredGrid.addHeaderButton("OBJECTSELECTOR_CANCEL","Cancel",ButtonCssClass.COLOR_DANGER).addEventListener(Events.ON_CLICK, this::onCancelButton);;
		Integer permissionValue=Permission.getPermissionByShortCode(mtTable.getFullTableName());
		if(PermissionFactory.getProvider().canWrite(permissionValue))
			filteredGrid.addHeaderButton("OBJECTSELECTOR_NEW","New",ButtonCssClass.COLOR_SECONDARY).addEventListener(Events.ON_CLICK, this::onNewButton);;
		window.setParent(DesktopHelper.getRootComponent());
		
		
	}
	
	
	
	void onCancelButton(Event evt) {
		isUpdated=false;
		window.detach();
	}
	
	protected void onNewButton(Event evt) {
		try {
	
			IDetailContainer container=DetailContainerProvider.getDetailContainer(mtTable);
			container.setParent(DesktopHelper.getRootComponent());
			//container.setInitialParameters(initialParameters);
			container.buildAndShowComponent(EditMode.INSERT);
		    if(null==container || container.isCancelled())return;
			isUpdated=true;
		    doModal();
		} catch (Throwable ex) {
			if ((ex instanceof ConstraintsException))
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null, 2000);
			else { 
				ex.printStackTrace();
				Messagebox.show(" Created", " Error !!!"  + ex.getMessage(),Messagebox.OK, Messagebox.ERROR);
			}
		}
	}
	
	void onSaveButton(Event evt) {
		if (filteredGrid.getEntityGrid().getSelectionMan().getSelectionCount()>0) {
			if(this.getSelector()!=GridSelectorType.CHECKBOX)
				detachedRecordAcceptor.getDrs().clear();
			detachedRecordAcceptor.acceptDetachedRecordFromObject(new ListValues<IDetachedRecord>().setNotNull(true).setNotRepeted(true).addAllValues(
					 filteredGrid.getEntityGrid().getSelectionMan().getChecked())
					,mtField);
			isUpdated=true;
			window.detach();
		}
		else
			Clients.showNotification("Nothing selected", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
	}

	public GridSelectorType getSelector() {
		return selector;
	}

	public void setSelector(GridSelectorType selector) {
		this.selector = selector;
	}

	public boolean isUpdated() {
		return isUpdated;
	}
}
