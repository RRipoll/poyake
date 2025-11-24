package com.jsantos.gui.form;

import java.util.Map.Entry;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Row;
import org.zkoss.zul.Window;

import com.jsantos.common.model.EditMode;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.datagrid4.GridSelectorType;
import com.jsantos.gui.detail.DetailContainerProvider;
import com.jsantos.gui.filteredgrid.FilteredGrid;
import com.jsantos.gui.zKpermission.Permission;
import com.jsantos.gui.zkutil.ButtonCssClass;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.orm.DBTransaction;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ConstraintsException;
import com.jsantos.orm.mt.MTHelper;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.search.AttributeConstants;

/**
 * @author raul ripoll
 */

public class CrudScreen extends Div{
	
	private static final long serialVersionUID = 1L;
	protected FilteredGrid filteredGrid;
	private Component parent;
	private MTTable table;
	private GridSelectorType selector=GridSelectorType.RADIO;
	private MapValues<Object> initialParameters;
	private Window window;
	private String filterSection = null;
	private Button cancel;
	private Integer permissionValue;
	private String searchName;
	private EventListener<Event> eventListener= new EventListener<Event>() {
		
		@Override
		public void onEvent(Event event) throws Exception {
			event.stopPropagation();
			if(event.getName().equals(CustomEvents.ON_DATAGRIDROWCLICK)) {
				Row row= (Row) event.getData();
				IDetachedRecord detachedRecord=(IDetachedRecord) row.getAttribute(AttributeConstants.DETACHED_RECORD);
				detail(detachedRecord);
			}
		}
	};	
	
	public  CrudScreen init(MTTable table,Component comp) throws Exception{
		parent=comp;
		permissionValue=Permission.getPermissionByShortCode(table.getFullTableName());
		this.setParent(parent);
		this.setHflex("true");
		this.setVflex("true");
		this.table=table;
		this.setStyle("top: 0;left: 0;padding: 0;");
		filteredGrid = new FilteredGrid(table, this);
		if(null!=searchName)filteredGrid.setSearchName(searchName);
		filteredGrid.setSelectorType(selector);
		filteredGrid.setEventListener(eventListener);
		filteredGrid.init();
		cancel=filteredGrid.addHeaderButton("CRUDSCREEN_OK",Zklabel.getLabel("ok"),ButtonCssClass.COLOR_SUCCESS);
		cancel.setStyle("display:none;");
		cancel.addEventListener(Events.ON_CLICK, this::cancelScreen);
		if(PermissionFactory.getProvider().canWrite(permissionValue))
			filteredGrid.addHeaderButton("CRUDSCREEN_DELETE",Zklabel.getLabel("delete"),ButtonCssClass.COLOR_DANGER  ).addEventListener(Events.ON_CLICK, this::deleteItem);
		if(PermissionFactory.getProvider().canRead(permissionValue))
			filteredGrid.addHeaderButton("CRUDSCREEN_DETAIL",Zklabel.getLabel("detail")  ,ButtonCssClass.COLOR_INFO    ).addEventListener(Events.ON_CLICK, this::editItem);
		if(PermissionFactory.getProvider().canWrite(permissionValue))
			filteredGrid.addHeaderButton("CRUDSCREEN_NEW",Zklabel.getLabel("new")   ,ButtonCssClass.COLOR_PRIMARY ).addEventListener(Events.ON_CLICK, this::newItem);
		filteredGrid.getDetachedQueryResult().setInitialParameters(initialParameters);
		filteredGrid.getDetachedQueryResult().setFilterSection(filterSection);
		
		return this;
	}
	
	public CrudScreen build() {
		
		filteredGrid.build();
		return this;
	}
	void cancelScreen(Event event) {
		window.detach();
	}
	
	void deleteItem(Event evt) {
		if (filteredGrid.getEntityGrid().getSelectionMan().getSelectionCount()>0) {
			if(!PermissionFactory.getProvider().canWrite(permissionValue))return;
			for (Object item : filteredGrid.getEntityGrid().getSelectionMan().getSelectedSet()) {
				new DBTransaction() {
					@Override
					protected void exec() {
						((IDetachedRecord)item).delete();
					}
				}.run();
			}
			filteredGrid.getEntityGrid().getSelectionMan().clear();
			filteredGrid.getEntityGrid().buildGrid();
		}else
			
		Clients.showNotification("Nothing selected", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
	}
	
	void editItem(Event evt) {
			if (filteredGrid.getEntityGrid().getSelectionMan().getSelectionCount()==1) {
				detail((IDetachedRecord) filteredGrid.getEntityGrid().getSelectionMan().getSingleSelectedKey());	
				filteredGrid.getEntityGrid().getSelectionMan().clear();
			}else
				Clients.showNotification("Nothing selected", Clients.NOTIFICATION_TYPE_INFO, null, null, 2000);
		}

	void detail(IDetachedRecord dr) {
			if(!PermissionFactory.getProvider().hasAnyPermission(permissionValue))return;
			try {
					IDetailContainer container=DetailContainerProvider.getDetailContainer(table);
					container.setDetachedRecord(dr);
					container.setInitialParameters(MTHelper.getValues(dr.getCopyValues()));
					container.setParent(parent);
					container=container.buildAndShowComponent(EditMode.AUTO);
					if(null==container || container.isCancelled())return;
					
					filteredGrid.getEntityGrid().buildGrid();
			} catch (Throwable ex) {
				if ((ex instanceof ConstraintsException))
					Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null, 2000);
				else throw ex;
			}
	}
	
	protected void newItem(Event evt) {
		try {
				if(!PermissionFactory.getProvider().canWrite(permissionValue))return;
				IDetailContainer container=DetailContainerProvider.getDetailContainer(table);
				container.setParent(parent);
				container.setInitialParameters(initialParameters);
				container.buildAndShowComponent(EditMode.INSERT);
				if(null==container || container.isCancelled())return;
			
		filteredGrid.getEntityGrid().buildGrid();
		} catch (Throwable ex) {
			if ((ex instanceof ConstraintsException))
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null, 2000);
			else { 
				ex.printStackTrace();
				Messagebox.show(" Created", " Error !!!"  + ex.getMessage(),Messagebox.OK, Messagebox.ERROR);
			}
		}
		
		
		
	}


	public MapValues< Object> getInitialParameters() {
		return initialParameters;
	}


	public CrudScreen setInitialParameters(MapValues<Object> initialParameters) {
		this.initialParameters = initialParameters;
		return this;
	}


	public String getFilterSection() {
		return filterSection;
	}

	public CrudScreen setFilterSection(String filterSection) {
		this.filterSection = filterSection;
		return this;
	}
	
	public CrudScreen setCollapsed(boolean collapsed) {
		if(null!=filteredGrid)
			filteredGrid.setCollapsed(!collapsed);
		return this;
	}

	public void doModal() {
		
		window= new Window();
		window.setWidth("90%");
		window.setHeight("90%");
		cancel.setStyle("margin:3px;display:flex;");
		this.setParent(window);
		window.setParent(DesktopHelper.getRootComponent());
		window.doModal();
	}

	public void setFilterSection(MapValues<Object> parameters) {
		this.setInitialParameters(parameters);
		String filtersection="";
		for (Entry<String, Object> entry : parameters.entrySet()) {
			filtersection+=" and "+entry.getKey()+"=:"+entry.getKey()+" ";
		}
		this.filterSection = filtersection;
	}

	public FilteredGrid getFilteredGrid() {
		return filteredGrid;
	}

	public void setFilteredGrid(FilteredGrid filteredGrid) {
		this.filteredGrid = filteredGrid;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
}
