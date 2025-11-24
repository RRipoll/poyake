package com.jsantos.gui.datagrid4;

import java.util.Collections;
import java.util.stream.Collectors;

import org.zkoss.util.resource.Labels;
import org.zkoss.zhtml.Div;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.SortEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.event.PagingEvent;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.common.model.conf.OrderByConfiguration;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.zkcomponent.MTSelectbox;
import com.jsantos.orm.dbstatement.DQResults;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.AttributeConstants;

/**
 * @author javier santos 
 * @author raul ripoll
 */

public class EntityGrid  {
	GridSelectorType selectorType=GridSelectorType.NONE;
	DetachedQueryResult dqr;
	int activePage = 0;
	boolean showPageSizeSelector = true;
	boolean showPaging = true;
	
	MTSelectbox pageSizeSelector = null;
	Div topComponent;
	SettingDTO settingDTO;
	
	private SelectionMan selectionMan; 
	
	EventListener<Event> eventListener;
	
	Grid grid;
	Auxhead auxhead;
	
	boolean autoSized =true;
	
	public EntityGrid(DetachedQueryResult dqr,SettingDTO settingDTO) {
		this.dqr = dqr;
		this.settingDTO=settingDTO;
		topComponent = new Div();
		topComponent.setSclass("h-100 v-100");
		topComponent.setStyle("position:relative;overflow-x:auto;");
	}

	public EntityGrid init() {
		
		if(null==settingDTO) {
			settingDTO=DesktopHelper.getSetting(dqr.getmTTable().getTableName(),  DesktopHelper.getInputUserId(), LocaleFactory.getProvider().getLocale());
		}
		
		if(null!=eventListener) {
			
			topComponent.addEventListener(CustomEvents.ON_DATAGRIDCELLCLICK, eventListener);
			topComponent.addEventListener(CustomEvents.ON_DATAGRIDCELLDOUBLECLICK, eventListener);
			topComponent.addEventListener(CustomEvents.ON_DATAGRIDROWCLICK, eventListener);
			topComponent.addEventListener(CustomEvents.ON_SELECTORCLICK, eventListener);
			topComponent.addEventListener(CustomEvents.ON_PAGING, eventListener);
			
		}
		selectionMan= new SelectionMan(selectorType);
		return this;
	}
	
	public Div buildGrid(){
		topComponent.getChildren().clear();
		grid = new Grid();
		grid.setSpan("true");
		grid.setParent(topComponent);
		
		if (selectorType == GridSelectorType.RADIO) { 
			Radiogroup radiogroup = new Radiogroup();
			radiogroup.setParent(topComponent);
			grid.setParent(radiogroup);
		}
		
		if (!autoSized)
			grid.setStyle("position:absolute;left:0px;top:0px;bottom:60px;right:0px;overflow-y:auto");
		Columns columns = new Columns();
		columns.setSizable(true);
		columns.setParent(grid);
		buildSelectorColumnHeader(columns);
		
		for (GridColumnConfiguration config:settingDTO.getColumnConfigurations()) {
			MTField mtField=config.getMtField();			
			if(null==mtField) {
				System.out.println(settingDTO.getaSName()+ "DataGrid Configuration is obsolete "+ config.getName() +" don't exits");
				Clients.showNotification("DataGrid Configuration is obsolete ", Clients.NOTIFICATION_TYPE_ERROR, null, null, 2000);
				continue;
			}
			if (config.isActive()) {
				Column column = new Column(LabelFactory.getProvider().get(config.getMtField(),LocaleFactory.getProvider().getLocale()));
				
				if(null==mtField.getLength())
					column.setHflex("min");
				else
					column.setHflex("1");
				column.setVisible(!config.isHidden());
				column.setDraggable("true");
				column.setDroppable("true");
				column.addEventListener(Events.ON_DROP, this::moveColumn);
				column.setParent(columns);
				column.setAttribute(AttributeConstants.COLUMN_CONFIGURATION, config);
				column.setHflex("min");
				try {
					column.setSort("auto");
				}
				catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
				OrderByConfiguration orderByConfiguration=(OrderByConfiguration)OrderByConfiguration.get(settingDTO.getOrderByConfigurations(),mtField);
				if(null!=orderByConfiguration) {
					if(orderByConfiguration.isActive())
						column.setSortDirection(orderByConfiguration.isAsc()?"ascending":"descending");
				    column.addEventListener(Events.ON_SORT, this::sort);
				    column.setAttribute(AttributeConstants.ORDER_BY_CONFIGURATION, orderByConfiguration);
				    }
				}
		}
		
		Rows rows = new Rows();
		rows.setParent(grid);
		
		dqr.setOrderByVector(settingDTO.getOrderByConfigurations().stream().filter(c -> c.active==true).collect(Collectors.toList()));
		
		DQResults<IDetachedRecord> results = dqr.getPage(activePage,DetachedRecord.class);
		
		RowEntity rowEntity= new RowEntity(selectionMan,   settingDTO);
		
		for (IDetachedRecord datarecord:results.getRawData()) {
			Row row = new Row();
			row.setAttribute(AttributeConstants.DETACHED_RECORD,datarecord);
			row.setParent(rows);
			selectionMan.buildSelectorColumn(row,datarecord,null);
			rowEntity.build(row, datarecord);
			row.addEventListener(Events.ON_CLICK, this::rowEvent);
		}
		
		if (null != dqr.getMaxResults() && dqr.getMaxResults()>dqr.getPageSize()) {
			Paging paging = new Paging();
			
			paging.setTotalSize(dqr.getMaxResults());
			paging.setPageSize(dqr.getPageSize());
			paging.setActivePage(activePage);
			
			paging.setSclass("mt-list-paging");
			paging.setMold("os");
			paging.addEventListener(CustomEvents.ON_PAGING, this::pagingEvent);
			
			paging.setVisible(showPaging);
		
			paging.setParent(topComponent);
		}
		
		if (showPageSizeSelector) {
			pageSizeSelector = new MTSelectbox();
			
			pageSizeSelector.add(10,  Labels.getLabel("pagination.format", new java.lang.Object[] {10}),true);
			pageSizeSelector.add(15,  Labels.getLabel("pagination.format", new java.lang.Object[] {15}),false);
			pageSizeSelector.add(20,  Labels.getLabel("pagination.format", new java.lang.Object[] {20}),false);
			pageSizeSelector.add(30,  Labels.getLabel("pagination.format", new java.lang.Object[] {30}),false);
			pageSizeSelector.add(100, Labels.getLabel("pagination.format", new java.lang.Object[] {100}),false);
			
			pageSizeSelector.setParent(topComponent);
			pageSizeSelector.setClass("mt-list-pagesize-selector");
			pageSizeSelector.setPk(dqr.getPageSize());
			pageSizeSelector.addEventListener(Events.ON_SELECT, this::pageSizeSelector);
		}
		return topComponent;
	}

	void pageSizeSelector(Event evt) throws Exception {
		if(null!=pageSizeSelector.getPk())
		setPageSize(pageSizeSelector.getPk());
		buildGrid();
	}
	
	void pagingEvent(Event evt) throws Exception {
		activePage = ((PagingEvent)evt).getActivePage();
		buildGrid();
	}
	
	void rowEvent(Event event) throws Exception {
		Events.sendEvent(CustomEvents.ON_DATAGRIDROWCLICK, topComponent, event.getTarget());
	}
	
	public void setPageSize(int pageSize) {
		dqr.setPageSize(pageSize);
	}
	
	public GridSelectorType getSelectorType() {
		return selectorType;
	}

	public EntityGrid setSelectorType(GridSelectorType selectorType) {
		this.selectorType = selectorType;
		return this;
	}

	void buildSelectorColumnHeader(Columns columns) {
		if (GridSelectorType.CHECKBOX == selectorType) {
			Column column = new Column();
			column.setWidth("45px");
			column.setParent(columns);
		}
		if (GridSelectorType.RADIO == selectorType) {
			Column column = new Column();
			column.setWidth("45px");
			column.setParent(columns);
		}
	}

	public void setWhereClause(String whereClause) {
		activePage=0;
		dqr.setWhereSection(whereClause);
	}

	public void setParamenters(MapValues<Object> parameters) {
		activePage=0;
		dqr.setParameters(parameters);
	}
	
	public void sort(Event event)  {
		SortEvent sortevent= (SortEvent)event;
		settingDTO.getOrderByConfigurations().stream().forEach(c-> c.setActive(false));
		OrderByConfiguration orderItem= ((OrderByConfiguration)sortevent.getTarget().getAttribute(AttributeConstants.ORDER_BY_CONFIGURATION));
		orderItem.setActive(true);
		orderItem.setAsc(!orderItem.isAsc());
		buildGrid();
		event.stopPropagation();
	}
	
	public void moveColumn(Event event) throws Exception  {
		DropEvent dropEvent=(DropEvent)event;
		GridColumnConfiguration target=(GridColumnConfiguration) event.getTarget().getAttribute(AttributeConstants.COLUMN_CONFIGURATION);
		GridColumnConfiguration dragged=(GridColumnConfiguration) dropEvent.getDragged().getAttribute(AttributeConstants.COLUMN_CONFIGURATION);
	  
	   int targetIndex=settingDTO.getColumnConfigurations().indexOf(target);
	   int draggedIndex=settingDTO.getColumnConfigurations().indexOf(dragged);
	   
	   if(targetIndex<draggedIndex) {
		   for (int j = draggedIndex; j > targetIndex; j--) {
			   Collections.swap(settingDTO.getColumnConfigurations(), j, j-1);}
		}
	   else {
		   for (int j = draggedIndex; j < targetIndex; j++) {
			   Collections.swap(settingDTO.getColumnConfigurations(), j+1, j);}
	   }
	   
	   buildGrid();
	}

	public DetachedQueryResult getDqr() {
		return dqr;
	}

	public EntityGrid setDqr(DetachedQueryResult dqr) {
		this.dqr = dqr;
		return this;
	}

	public int getActivePage() {
		return activePage;
	}

	public EntityGrid setActivePage(int activePage) {
		this.activePage = activePage;
		return this;
	}

	public Div getParent() {
		return topComponent;
	}

	public EntityGrid setParent(Div parent) {
		this.topComponent = parent;
		return this;
	}

	public boolean isShowPageSizeSelector() {
		return showPageSizeSelector;
	}

	public EntityGrid setShowPageSizeSelector(boolean showPageSizeSelector) {
		this.showPageSizeSelector = showPageSizeSelector;
		return this;
	}
	
	public boolean isAutoSized() {
		return autoSized;
	}

	public EntityGrid setAutoSized(boolean autoSized) {
		this.autoSized = autoSized;
		return this;
	}

	public SettingDTO getSettingDTO() {
		return settingDTO;
	}

	public EntityGrid setSettingDTO(SettingDTO settingDTO) {
		this.settingDTO = settingDTO;
		return this;
	}

	public Div getTopComponent() {
		return topComponent;
	}

	
	public boolean isShowPaging() {
		return showPaging;
	}

	public void setShowPaging(boolean showPaging) {
		this.showPaging = showPaging;
	}
	public ISelectionMan getSelectionMan() {
		return selectionMan;
	}

	public EventListener<Event> getEventListener() {
		return eventListener;
	}

	public EntityGrid setEventListener(EventListener<Event> eventListener) {
		this.eventListener = eventListener;
		return this;
	}
}
