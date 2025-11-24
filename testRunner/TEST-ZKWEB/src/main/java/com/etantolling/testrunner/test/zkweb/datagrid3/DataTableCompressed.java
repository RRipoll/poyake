package com.etantolling.testrunner.test.zkweb.datagrid3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.impl.NumberInputElement;

import com.etantolling.testrunner.test.core.db.OrderByItem;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.zkweb.DesktopHelper;
import com.etantolling.testrunner.test.zkweb.datagrid3.RenderedObjects.DataTableNH;
import com.etantolling.testrunner.test.zkweb.datagrid3.filter.DataGridFilter;
import com.etantolling.testrunner.test.zkweb.datagrid3.filter.DataGridFilterExtend;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class DataTableCompressed {

	private String sql;
	private DataGridModel dgModel;
	private DataTable dataTable;
	private Component filterComponent;
	private Component parent; 
	private EventListener<Event> eventListener;
	private DataGridFilter filter;
	private BasicRowAdapter adapter;
	private Integer paging;
	private Integer selector;
	private boolean refreshOnFilterChange =true;
	private Hashtable<String,Object> initialParameters=new Hashtable<String,Object>();
	private LinkedHashMap<String, String>initialChecked;
	private String dataTableNameID=null;
	private Integer pageSize;
	private String height;
	public boolean columnInARow=false;
	public boolean linkInFirstColumn=true;
	private boolean showCheckBoxOnGroup = false;
	public boolean inverterCheckbox =false;
	public boolean isSortable=true;
	private String extraHeaderZull;
	
	Vector<OrderByItem> orderByVector = null;
	
	String Css;
	private IUpdateTable updateTable;
	
	//private String width;
	private int minNumberOfSearchParameters=0;
	
	private int eventColumn = 0;
	
	
	public int getMinNumberOfSearchParameters() {
		return minNumberOfSearchParameters;
	}


	public void setMinNumberOfSearchParameters(int minNumberOfSearchParameters) {
		this.minNumberOfSearchParameters = minNumberOfSearchParameters;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isColumnInARow() {
		return columnInARow;
	}

	public void setColumnInARow(boolean columnInARow) {
		this.columnInARow = columnInARow;
	}

	public boolean isLinkInFirstColumn() {
		return linkInFirstColumn;
	}
	

	public void setLinkInFirstColumn(boolean linkInFirstColumn) {
		this.linkInFirstColumn = linkInFirstColumn;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	
	public DataTableCompressed(String dataTableNameID, String sql, Component filterComponent, Component parent, EventListener<Event> eventListener) {
		this.filterComponent=filterComponent;
		this.parent=parent;
		this.eventListener=eventListener;
		this.sql=sql;
		setDataTableNameID(dataTableNameID);
	}
	
	
	public DataTableCompressed(String sql, Component filterComponent, Component parent, EventListener<Event> eventListener) {
		this.filterComponent=filterComponent;
		this.parent=parent;
		this.eventListener=eventListener;
		this.sql=sql;
	}
	
	public DataTableCompressed(String sql, Component filterComponent, Component parent, EventListener<Event> eventListener, int eventColumn) {
		this.filterComponent=filterComponent;
		this.parent=parent;
		this.eventListener=eventListener;
		this.sql=sql;
		this.eventColumn = eventColumn;
	}
	
	
	public void setOrderByField(String field, boolean ord){
		if(null!=dgModel){
			dgModel.getDgQuery().setOrderByField(field, ord);
			}
	}
	
	public void setPageSize(int pageSize){
		this.pageSize=pageSize;
		if(null!=dgModel)dgModel.getDgQuery().setPageSize(pageSize);
	}
	
	public DataTable init() throws SQLException{
		
		if(null != parent && parent instanceof Div && null!=((Div)parent).getHeight() && ((Div)parent).getHeight().contains("%") ){
			Integer height=Integer.parseInt(((Div)parent).getHeight().replace("%", ""));
			if(null!=DesktopHelper.getClientHeightByN(new Double(height)/100))
				((Div)parent).setHeight(DesktopHelper.getClientHeightByN(new Double(height)/100)+"px");
		}
		
		if(null==filter){
			if(null!=filterComponent)
				filterComponent.setAttribute("initialParameters", initialParameters);
			filter= new DataGridFilterExtend(filterComponent,null);
		
		}
		if(null!=eventListener)filter.addEventListener("onApplyChanges", eventListener);
		if(null==dgModel){
			dgModel= new DataGridModel(dataTableNameID,sql,initialParameters);
			if(null!=pageSize)dgModel.getDgQuery().setPageSize(pageSize);
			if(null!=height) dgModel.setHeight(height);
			else{
				if(parent instanceof Div && null!=((Div)parent).getHeight()){
					String height=((Div)parent).getHeight();
					if(height.contains("px")){
						dgModel.setHeight(height);
					}
				}
			}
		}
		if(null==adapter){
			if(linkInFirstColumn && null!=eventListener)
				adapter= new BasicRowAdapterEventId(this.eventColumn);
			else adapter= new BasicRowAdapter();
		}
		
		if(null==paging)paging=DataTable.PAGING;
		if(null==selector )selector=DataTable.SELECTOR_NONE;
		if(null==dataTable){
				dataTable = new DataTableNH(dgModel, filter, adapter, eventListener,paging, null);
				dataTable.setSortable(isSortable);
			
			dataTable.setExtraHeaderZull(extraHeaderZull);
			dataTable.inverterCheckbox=inverterCheckbox;
			dataTable.setMinNumberOfSearchParameters(minNumberOfSearchParameters);
			
		}
		{
			dataTable.setSelectorType(selector);
			//dataTable.setPagingType(paging);
			dataTable.setStyle("overflow-y: auto;");
			dataTable.setParent(parent);
			if(null!=initialChecked)dataTable.setInitialChecked(initialChecked);
		}
		
		if(null!=orderByVector)dataTable.dgModel.dgQuery.setOrderByVector(orderByVector);
		
		
		addEventListenerToFilter();
		setZulAttributes();
		
		return dataTable;
	}

	public Vector<LinkedHashMap<String, Object>> render() throws SQLException{
		dgModel.getDgQuery().setFilterSection(filter.buildWhereClause(),filter.getParameters(),paging==DataTable.PAGING_NOCOUNT);
		if(paging!=DataTable.PAGING_NOCOUNT)dataTable.dgModel.dgQuery.forceRowCount();
		return dataTable.render();
	}
	
	public Vector<LinkedHashMap<String, Object>> render(String extraWhere) throws SQLException{
		dgModel.getDgQuery().setFilterSection(filter.buildWhereClause()+extraWhere,filter.getParameters(),paging==DataTable.PAGING_NOCOUNT);
		dataTable.dgModel.dgQuery.forceRowCount();
		return dataTable.render();
	}
	
	
	public void addEventListenerToFilter(){
		
		if(null!=filterComponent && null!=filter){
			
			Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeValue(filterComponent, "type","FILTER");
			for (Component component : components) {
				
				if(refreshOnFilterChange){
					if(component instanceof Textbox || component instanceof NumberInputElement){
						component.addEventListener(Events.ON_BLUR,filter);
					}else if(component instanceof Button || component instanceof Label){
						component.addEventListener(Events.ON_CLICK,filter);
					}else if(component instanceof Checkbox || component instanceof Radio){
						component.addEventListener(Events.ON_CHECK,filter);
					}else if(component instanceof Datebox  || component instanceof Combobox){
						component.addEventListener(Events.ON_CHANGE,filter);
					}else{
						component.addEventListener(Events.ON_BLUR,filter);
					}
				}else if(component instanceof Button || component instanceof Label){
					component.addEventListener(Events.ON_CLICK,filter);
				}
			}
			if(null!=eventListener)filter.addEventListener("onApplyChanges", eventListener);
		}
	}

	public void setRefreshOnFilterChange(boolean b) {
		refreshOnFilterChange=b;
	}

	public DataGridFilter getFilter() {
		return filter;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public DataGridModel getDgModel() {
		return dgModel;
	}

	public void setDgModel(DataGridModel dgModel) {
		this.dgModel = dgModel;
	}

	public DataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(DataTable dataTable) {
		this.dataTable = dataTable;
	}

	public Component getFilterComponent() {
		return filterComponent;
	}

	public void setFilterComponent(Component filterComponent) {
		this.filterComponent = filterComponent;
	}

	public Component getParent() {
		return parent;
	}

	public void setParent(Component parent) {
		this.parent = parent;
	}

	public EventListener<Event> getEventListener() {
		return eventListener;
	}

	public void setEventListener(EventListener<Event> eventListener) {
		this.eventListener = eventListener;
	}

	public BasicRowAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(BasicRowAdapter adapter) {
		this.adapter = adapter;
	}

	public Integer getPaging() {
		return paging;
	}

	public void setPaging(Integer paging) {
		this.paging = paging;
	}

	public Integer getSelector() {
		return selector;
	}

	public void setSelector(Integer selector) {
		this.selector = selector;
		if(null!=getDataTable()) getDataTable().setSelectorType(selector);
	}

	public Hashtable<String, Object> getInitialParameters() {
		return initialParameters;
	}

	public void setInitialParameters(Hashtable<String, Object> initialParameters) {
		this.initialParameters = initialParameters;
	}

	public void setInitialParameter(String name, Object value) {
		initialParameters.put(name, value);
	}

	public boolean isRefreshOnFilterChange() {
		return refreshOnFilterChange;
	}

	public void setFilter(DataGridFilter filter) {
		this.filter = filter;
	}
	
	public void setZulAttributes(){
		
		if(null!=parent && parent.getAttributes().size()>0)
			for(Object key:parent.getAttributes().keySet()){
				if(parent.getAttributes().get(key) instanceof String){
					String sValue=(String) parent.getAttributes().get(key);
					String[] items=sValue.split(";");
					for(int i=0;i<items.length;i++){
						String[] parts=items[i].split(":");
						String type=parts[0];
						if(type.equals("width")){dgModel.getColumnWidths().put((String) key, parts[1]);}
						else if(type.equals("header")){dgModel.getHeaderLabels().put((String) key, parts[1]);}
						else if(type.equals("hide")){dgModel.getHiddenColumns().add((String) key);}
						else if(type.equals("style")){dgModel.getColumnSize().put((String) key, (parts[1]).replace("->", ":"));}
						else if(type.equals("hflex")){dgModel.getColumnHFlex().put((String) key, (parts[1]));}
						else if(type.equals("format")){dgModel.getColumnFormat().put((String) key, (parts[1]));}
						else if(type.equals("align")){dgModel.getColumnAlign().put((String) key, (parts[1]));}
						else if(type.equals("detail")){dgModel.getColumnDetail().put((String) key, (parts[1]));}
						else if(type.equals("editable")){dgModel.getColumnEditable().put((String) key, (parts[1]));}
					}
				}
			}
		}

	public SelectionMan getSelectionMan() {
		if(null!=dataTable)	return dataTable.getSelectionMan();
		else return null;
	}

	public LinkedHashMap<String, String> getInitialChecked() {
		if(null!=dataTable) return dataTable.getInitialChecked();
		if(null==initialChecked)initialChecked=new LinkedHashMap<String, String>();
		return initialChecked;
	}

	public void setInitialChecked(LinkedHashMap<String, String> initialChecked) {
		if(null!=dataTable) dataTable.setInitialChecked(initialChecked);
		else this.initialChecked = initialChecked;
	}

	public String getDataTableNameID() {
		return dataTableNameID;
	}

	public void setDataTableNameID(String dataTableNameID) {
		//System.out.println(dataTableNameID+" this name must be unique in the app otherwise, a  sql error was shown");
		this.dataTableNameID = dataTableNameID;
		
	}
	
	public Component getCellDiv(LinkedHashMap<String, Object> row,String fieldName){
		return getAdapter().getLinkObjectDiv().get(row).get(fieldName);
	}
	
	
	
	
	
	public Vector<LinkedHashMap<String, Object>> getTotalResults() throws SQLException{
		Vector<LinkedHashMap<String, Object>> retvalues=null;
		try(Connection conn=MainDb.getConnection()){
			dgModel.getDgQuery().setFilterSection(filter.buildWhereClause(),filter.getParameters(),true);
			retvalues= dgModel.getDgQuery().getTotalResults(conn);
		}
		return retvalues;
		}

	public boolean isSortable() {
		return isSortable;
	}

	public void setSortable(boolean isSortable) {
		this.isSortable = isSortable;
	}

	public String getExtraHeaderZull() {
		return extraHeaderZull;
	}

	public void setExtraHeaderZull(String extraHeaderZull) {
		this.extraHeaderZull = extraHeaderZull;
	}

	public Vector<OrderByItem> getOrderByVector() {
		return orderByVector;
	}

	public void setOrderByVector(Vector<OrderByItem> orderByVector) {
		this.orderByVector = orderByVector;
	}
	
	public Integer getTotalRowCount() throws SQLException{    
		return getDgModel().dgQuery.getRowCount();
		
	}
	
	public boolean isShowCheckBoxOnGroup() {
		return showCheckBoxOnGroup;
	
	} 

	public void setShowCheckBoxOnGroup(boolean showCheckBoxOnGroup) {
		this.showCheckBoxOnGroup = showCheckBoxOnGroup;
	}
	
	public void setUpdateTable(IUpdateTable updateTable){
		this.updateTable=updateTable;
	}
	
	
	

	public IUpdateTable getUpdateTable() {
		return updateTable;
	}
}
