package com.jsantos.gui.filteredgrid;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Label;
import org.zkoss.zul.Popup;

import com.jsantos.common.util.MapValues;
import com.jsantos.common.util.MetadataUtil;
import com.jsantos.factory.internationalization.LabelFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.datagrid4.EntityGrid;
import com.jsantos.gui.datagrid4.FilterGroup;
import com.jsantos.gui.datagrid4.GridSelectorType;
import com.jsantos.gui.form.CrudScreen;
import com.jsantos.gui.zkutil.CSSClassList;
import com.jsantos.gui.zkutil.ComponentTreeTransverser;
import com.jsantos.gui.zkutil.IdUtil;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.orm.dbstatement.DetachedQueryResult;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTTable;

/**
 * @author raul ripoll
 */

public class FilteredGrid {
	Component parent;
	Component filtersDiv;
	Component gridDiv;
	Component listScreenDiv;
	Label collapseButton;
	Component searchButton;
	Component customButton;
	Component resetFilterButton;
	Label headerLabel;
	Div listFilterDiv;
	Div listContentDiv;
	EntityGrid entityGrid;	
	MTTable mtTable;
	boolean collapsed = false;
	String sHeaderLabel; 
	FilterGroup filterGrid;
	private boolean embeddedStyle;
	Popup menuPopup;
	Div filterLabel;
	CustomFilteredGrid customFilteredGrid;
	Div buttonArea;
	Div headerDiv;
    DetachedQueryResult detachedQueryResult;
    GridSelectorType selector=GridSelectorType.NONE;
    String searchName;
    boolean isInitialised=false;
    EventListener<Event> eventListener;
    
	public EventListener<Event> getEventListener() {
		return eventListener;
	}

	public void setEventListener(EventListener<Event> eventListener) {
		this.eventListener = eventListener;
	}

	public FilteredGrid(MTTable mtTable, Component parent){
		this.mtTable = mtTable;
		this.parent = parent;
		detachedQueryResult=new DetachedQueryResult(mtTable);
		
	}
	
	public FilteredGrid(DetachedQueryResult dqr, Component parent) throws ApiException {
		this.mtTable = dqr.getmTTable();
		this.parent = parent;
		detachedQueryResult=dqr;
	}
	
	public FilteredGrid init(){
		
		parent.getChildren().clear();
		if(null==searchName)searchName=mtTable.getTableName();
		customFilteredGrid= new CustomFilteredGrid(parent, searchName);
		parent.addEventListener(CustomEvents.ON_CHANGINGCONF, this::refresh);
		
		listScreenDiv = Executions.createComponents("~./common/zul/standardlistscreen/standardgridscreen.zul", parent, null);
		sHeaderLabel = Zklabel.getLabel(mtTable.getTableName(),LocaleFactory.getProvider().getLocale()) ;
		parent.appendChild(listScreenDiv);
		gridDiv = listScreenDiv.getFellow("GRID");
		filtersDiv = listScreenDiv.getFellow("FILTERS");
		collapseButton = (Label) listScreenDiv.getFellow("COLLAPSE_FILTER_BUTTON");
		listFilterDiv = (Div)listScreenDiv.getFellowIfAny("LIST_FILTER_DIV");
		listContentDiv = (Div)listScreenDiv.getFellowIfAny("LIST_CONTENT_DIV");
		headerLabel = ((Label)listScreenDiv.getFellowIfAny("HEADER_LABEL"));
		listScreenDiv.getFellow("SEARCH_BUTTON").addEventListener(Events.ON_CLICK, this::search);
		headerDiv= (Div) listScreenDiv.getFellow("HEADER_DIV");
		
		if(DesktopHelper.isConfEditable()) {
			listScreenDiv.getFellow("CONF_EDITABLE").setVisible(true);
			listScreenDiv.getFellow("CONF_FILTER_BUTTON").addEventListener(Events.ON_CLICK, this::customFilter);;
			listScreenDiv.getFellow("CONF_COLUMNS_BUTTON").addEventListener(Events.ON_CLICK, this::customColumns);
			listScreenDiv.getFellow("CONF_ORDERBY_BUTTON").addEventListener(Events.ON_CLICK, this::customOrderBy);
			listScreenDiv.getFellow("JSON_CONF_BUTTON").addEventListener(Events.ON_CLICK, this::jsonEdit);
		}else listScreenDiv.getFellow("CONF_EDITABLE").setVisible(false);
		
		if(DesktopHelper.isPermissionEditable()) {
			listScreenDiv.getFellow("PERMISSIONS").setVisible(true);
			listScreenDiv.getFellow("PERMISSIONS_BUTTON").addEventListener(Events.ON_CLICK, this::editPermissions);;
		}else listScreenDiv.getFellow("PERMISSIONS").setVisible(false);
		
		if(DesktopHelper.isLabelEditable()) {
			listScreenDiv.getFellow("LABELS").setVisible(true);
			listScreenDiv.getFellow("LABELS_BUTTON").addEventListener(Events.ON_CLICK, this::editLabels);;
		}else listScreenDiv.getFellow("LABELS").setVisible(false);
		
		if(mtTable.getStereotypes().contains("CONFIG")) {
			listScreenDiv.getFellow("METADATA").setVisible(true);
			listScreenDiv.getFellow("METADATA_BUTTON").addEventListener(Events.ON_CLICK, this::getMetadataData);;
		}else listScreenDiv.getFellow("METADATA").setVisible(false);
		
		listScreenDiv.getFellow("DROPDOWN_MENU").addEventListener(Events.ON_CLICK, this::popupMenu);
		
		listScreenDiv.getFellow("RESET_FILTER_BUTTON").addEventListener(Events.ON_CLICK, this::resetFilter);
		
		menuPopup = (Popup)listScreenDiv.getFellow("DROPDOWN_MENU_POPUP");
		filterLabel = (Div)listScreenDiv.getFellow("FILTER_LABEL");
		buttonArea = (Div)listScreenDiv.getFellowIfAny("GRID_BUTTON_AREA");
		
		for (Component c:ComponentTreeTransverser.transverseTree(parent))
			if (StringUtils.isNotBlank(c.getId()))
				c.setId(IdUtil.generateRandomId());
		entityGrid = new EntityGrid(detachedQueryResult,customFilteredGrid.getSettingDTO());
		entityGrid.setSelectorType(selector);
		entityGrid.setEventListener(eventListener);
		entityGrid.init();
		isInitialised=true;
		
		return this;
	}

	void popupMenu(Event evt) {
		menuPopup.setParent(evt.getTarget());
		menuPopup.open(evt.getTarget(), "overlap");
	}
	void editPermissions(Event evt) {
			
		try {
			new CrudScreen()
			.setFilterSection(
					" and " + MTBase.getMTField("VPERMISSIONROL.SHORTCODE").getName()+"=:"+MTBase.getMTField("VPERMISSIONROL.SHORTCODE").getName() +
					" and " + MTBase.getMTField("VPERMISSIONROL.PERMISSIONTYPEID").getName()+"=:"+MTBase.getMTField("VPERMISSIONROL.PERMISSIONTYPEID").getName()
			)
			.setInitialParameters(new MapValues<>()
					.add(MTBase.getMTField("VPERMISSIONROL.SHORTCODE").getName(),mtTable.getFullTableName())
					.add(MTBase.getMTField("VPERMISSIONROL.PERMISSIONTYPEID").getName(),PermissionFactory.getProvider().getPermissionType("MTTABLE"))
					)
			.init(MTBase.getTable("VPERMISSIONROL"), parent)
			.setCollapsed(true)
			.build().doModal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	void getMetadataData(Event evt) {
		
		try {
			MTTable table=mtTable;
			if(table.isView())
				table=table.getPrimaryKey().getRealField().getTable();
			Filedownload.save(MetadataUtil.getMDD(table, table.getTableName()+".txt"), "text/plain");
		
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void editLabels(Event evt) {
		
		try {
			CrudScreen screen=new CrudScreen()
			.init(MTBase.getTable("MTLABEL"), parent)
			.setCollapsed(true);
			
			screen.getFilteredGrid().getDetachedQueryResult().setCustomSql(LabelFactory.getProvider().getScreenSearchSql(mtTable));
			screen.build().doModal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void build() {
		if(!isInitialised)init();
		headerLabel.setValue(sHeaderLabel);
		gridDiv.getChildren().clear();
		entityGrid.setAutoSized(false);
		gridDiv.appendChild(entityGrid.buildGrid());
		if (isEmbeddedStyle()) {
			headerLabel.getParent().setVisible(false);
		}
		filterGrid=new FilterGroup(customFilteredGrid.getSettingDTO(),filtersDiv);
		filterGrid.buildFilter();
		
		if (null != collapseButton)
			collapseButton.addEventListener(Events.ON_CLICK, this::collapse);
		
		collapse(null);
		
		if (isEmbeddedStyle()) {
			CSSClassList.add(listFilterDiv, "mt-list-embedded");
			CSSClassList.add(listContentDiv, "mt-list-embedded");
		}
	}
	
	
	public void collapse(Event event) {
		if (null != listFilterDiv) {
			if (!collapsed) {
				listFilterDiv.setSclass("card w-25 mt-filter-container-collapsed");
				filterLabel.setVisible(false);
				collapsed = true;
				collapseButton.setValue(Zklabel.getLabel("filter_open"));
			}
			else {
				listFilterDiv.setSclass("card w-25 mt-filter-container");
				filterLabel.setVisible(true);
				collapsed = false;
				collapseButton.setValue(Zklabel.getLabel("filter_collapse"));
				
			}
		}
		if (isEmbeddedStyle()) {
			CSSClassList.add(listFilterDiv, "mt-list-embedded");
			CSSClassList.add(listContentDiv, "mt-list-embedded");
		}
		
		menuPopup.detach();
	}
	
	public void search(Event event) throws Exception {
		//Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeValue(filtersDiv, "type",AttributeConstants.FILTER);
		MapValues<Object> paramenters=new MapValues<Object>();
		String whereClause=filterGrid.getWhereClause(paramenters);
		entityGrid.setWhereClause(whereClause);
		entityGrid.setParamenters(paramenters);
		gridDiv.getChildren().clear();
		gridDiv.appendChild(entityGrid.buildGrid());
		
	}
	
	
	public void customFilter(Event event) throws Exception {
		customFilteredGrid.buildAndShowFilter();
		menuPopup.detach();

	}
	public void customColumns(Event event) throws Exception {
		customFilteredGrid.buildAndShowColumns();
		menuPopup.detach();

	}
	public void customOrderBy(Event event) throws Exception {
		customFilteredGrid.buildAndShowOrderBy();
		menuPopup.detach();

	}
	
	public void jsonEdit(Event event) throws Exception {
		customFilteredGrid.jsonEditor();
		menuPopup.detach();
	}
	
	public void refresh(Event event) throws Exception {
		entityGrid.buildGrid();
		filterGrid.buildFilter();

	}
	
	public void resetFilter(Event event) throws Exception {
		filterGrid.buildFilter();
		menuPopup.detach();
	}

	public EntityGrid getEntityGrid() {
		return entityGrid;
	}

	public String getHeaderLabel() {
		return sHeaderLabel;
	}

	public void setHeaderLabel(String headerLabel) {
		this.sHeaderLabel = headerLabel;
	}
	public boolean isEmbeddedStyle() {
		return embeddedStyle;
	}

	public void setEmbeddedStyle(boolean embeddedStyle) {
		this.embeddedStyle = embeddedStyle;
	}
	

	public CustomFilteredGrid getCustomFilteredGrid() {
		return customFilteredGrid;
	}

	public void setCustomFilteredGrid(CustomFilteredGrid customFilteredGrid) {
		this.customFilteredGrid = customFilteredGrid;
	}

	public Div getButtonArea() {
		return buttonArea;
	}

	public Div getHeaderDiv() {
		return headerDiv;
	}

	public void setHeaderDiv(Div headerDiv) {
		this.headerDiv = headerDiv;
	}
	
	
	public Button addHeaderButton(String ID, String label, String colorClass) {
		
		
		Button button = new Button(label);
		button.setId(ID);
		button.setSclass("float-right btn " +colorClass);
		button.setParent(getHeaderDiv());
		//new Text(label).setParent(button);
		button.setStyle("margin:3px");
		button.addEventListener(Events.ON_CLICK, this::addingDataToButton);
		return button;
	}
	void addingDataToButton(Event event) {
		Events.sendEvent(new Event(CustomEvents.ON_HEADERBUTTON_CLICK, event.getTarget(), getEntityGrid().getSelectionMan().getSelectedSet()));
		//entityGrid.buildGrid();
	}
	public DetachedQueryResult getDetachedQueryResult() {
		return detachedQueryResult;
	}

	public void setDetachedQueryResult(DetachedQueryResult detachedQueryResult) {
		this.detachedQueryResult = detachedQueryResult;
	}

	public boolean isCollapsed() {
		return collapsed;
	}

	public void setCollapsed(boolean collapsed) {
		this.collapsed = collapsed;
	}

	public void setSelectorType(GridSelectorType selector) {
		this.selector=selector;
		
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
}
