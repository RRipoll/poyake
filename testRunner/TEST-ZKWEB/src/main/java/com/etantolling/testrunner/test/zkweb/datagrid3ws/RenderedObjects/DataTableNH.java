package com.etantolling.testrunner.test.zkweb.datagrid3ws.RenderedObjects;

import java.util.LinkedHashMap;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Column;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Html;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;
import org.zkoss.zul.impl.HeaderElement;

import com.etantolling.testrunner.test.zkweb.datagrid3ws.BasicRowAdapter;
import com.etantolling.testrunner.test.zkweb.datagrid3ws.DataGridModel;
import com.etantolling.testrunner.test.zkweb.datagrid3ws.DataGridQuery;
import com.etantolling.testrunner.test.zkweb.datagrid3ws.DataTable;
import com.etantolling.testrunner.test.zkweb.datagrid3ws.filter.DataGridFilter;
import com.etantolling.testrunner.test.zkweb.zkutil.ComponentTreeTransverser;

public class DataTableNH extends DataTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4825478966358903245L;
	
	
	public DataTableNH(DataGridModel dgModel, DataGridFilter filter, BasicRowAdapter rowAdapter, EventListener<Event> eventListener, String cssClass) throws Exception {
		super(dgModel, filter, rowAdapter, eventListener, cssClass);
	}

	public DataTableNH(DataGridModel dgModel, DataGridFilter filter, BasicRowAdapter rowAdapter, EventListener<Event> eventListener,Integer pagingType, String cssClass) throws Exception {
		super(dgModel, filter, rowAdapter, eventListener,pagingType, cssClass);
	}
	
	@Override
	public Vector<LinkedHashMap<String, Object>> render() throws Exception {

		System.out.println("number of cicles:"+ ++numberOfCicles);
		
		if(isOnlyPageCheckbox){
			selectionMan.selectedSet.clear();
			VectorCheckBox.clear();
		}
		
		dgModel.getDgQuery().getRowCount();
		
		if(null!=dgModel.getDgQuery().getMaxResults() && dgModel.getDgQuery().getMaxResults()<dgModel.getDgQuery().getRowCount())
			throw new WrongValueException(null,"Search returns more than "+dgModel.getDgQuery().getMaxResults()+" results, Please refine your search ");
	
		if (null != mainComponent){
			parentComponent.removeChild(mainComponent);
		}
		Grid grid = new Grid();
		//grid.setVflex("1");
		
		if(null!=dgModel.getHeight()){
		    String height=dgModel.getHeight();
			if(height.contains("px")){
				height=height.replace("px", "");	
				height=(Integer.parseInt(height)-55)+"px";
				grid.setHeight(height);		
				String style="border-collapse:collapse;max-height:"+height;
				grid.setStyle(grid.getStyle()+";"+style);
			}else{ grid.setHeight(dgModel.getHeight());
				grid.setStyle(grid.getStyle()+";border-collapse:collapse;");
			}
		}else grid.setStyle(grid.getStyle()+";border-collapse:collapse;");
		
		grid.setWidth(dgModel.getWidth());
		
		Radiogroup group = null;
		if (SELECTOR_RADIO == getSelectorType()) {
			group = new Radiogroup();
			grid.setParent(group);
		}

		getRowAdapter().reset();

		renderHeaders(grid);
		Vector<LinkedHashMap<String, Object>> page=renderBody(grid);

		if (SELECTOR_RADIO == getSelectorType()){
			mainComponent = group;
		}else{
			mainComponent = grid;
		}
		mainComponent.setParent(parentComponent);
		
		if(null != pagination){
			pagination.setActivePage(dgModel.getPageNumber());
			pagination.setPageSize(dgModel.dgQuery.getPageSize());
			pagination.setRowCount(dgModel.getDgQuery().getRowCount());
			if(pagination.pag.getPageCount()<2){
				pagingComponent.setVisible(false);
			}else pagingComponent.setVisible(true);
		}
		return page;
	}

	@Override
	public void renderHeaders(Component grid) {
		
		Component extraHead=null;
		if(null!=getExtraHeaderZull()){
			extraHead=Executions.createComponents(getExtraHeaderZull(),null, null);
			if(extraHead instanceof Auxhead){
				extraHead.setParent(grid);
			}else{
				for (Component com : ComponentTreeTransverser.getComponentsByAttributeName(extraHead,"auxhead")) {
					com.setParent(grid);
				}
				
			}
		}
		Columns columns = new Columns();
		columns.setParent(grid);

		if (SELECTOR_CHECKBOX == selectorType) {
			Component column;
			if(null!=extraHead && ComponentTreeTransverser.getComponentsByAttributeValue(grid, "selectortype","SELECTOR_CHECKBOX").size()>0){
				column =ComponentTreeTransverser.getComponentsByAttributeValue(grid, "selectortype","SELECTOR_CHECKBOX").firstElement();
				new Column().setParent(columns);
			}else {column = new Column();
				column=new Column();
				((HtmlBasedComponent) column).setWidth("35px");
				column.setParent(columns);
			}
			pageCheckbox.setParent(column);
			pageCheckbox.setAttribute("GLOBAL_CHECKBOX", "YES");
			pageCheckbox.addEventListener("onCheck", this);

		}
		if (SELECTOR_RADIO == selectorType) {
			Component column;
			if(null!=extraHead && ComponentTreeTransverser.getComponentsByAttributeValue(grid, "selectortype","SELECTOR_RADIO").size()>0){
				column =ComponentTreeTransverser.getComponentsByAttributeValue(grid, "selectortype","SELECTOR_RADIO").firstElement();
				new Column().setParent(columns);
			}else {column = new Column();
				column=new Column();	
				((HtmlBasedComponent) column).setWidth("35px");
				column.setParent(columns);
			}
			
			
		}

		DataGridQuery dgQuery = getDgModel().getDgQuery();
		for (String headerName : dgQuery.getColumnNames()) {
			if (dgModel.getHiddenColumns().contains(headerName.toUpperCase())){
				continue;
			}
			if (null != getDgModel().getHeaderLabels().get(headerName)) {
				
				Component column;
				if(null!=extraHead && ComponentTreeTransverser.getComponentsByAttributeValue(grid, "field",headerName).size()>0){
					column =ComponentTreeTransverser.getComponentsByAttributeValue(grid, "field",headerName).firstElement();
					new Column().setParent(columns);
				}else{
					column = new Column();
					column.setParent(columns);
				}
					column.setAttribute("COLUMN_POSITION", new Integer(dgQuery.getColumnNames().indexOf(headerName)));
					column.setAttribute("COLUMN_ORDERBY_NAME", headerName);
					if(column instanceof Column)((HeaderElement) column).setAlign("center");
				
					if (null != getDgModel().getColumnWidth(headerName) && column instanceof Column){
						((HtmlBasedComponent) column).setWidth(getDgModel().getColumnWidth(headerName));
					}
					if (null != dgModel.getColumnSize(headerName) && column instanceof Column){
						((HtmlBasedComponent) column).setStyle(dgModel.getColumnSize(headerName));
					}
					if (null != dgModel.getColumnHFlex(headerName) && column instanceof Column){
						((HtmlBasedComponent) column).setHflex(dgModel.getColumnHFlex(headerName));
					}
				
					Html text = new Html();
					text.setParent(column);
					String content=getDgModel().getHeaderLabels().get(headerName);
					if(null==initialChecked && isSortable)column.addEventListener("onClick", this);
					if (null != dgQuery.getOrderByField()){
						if (dgQuery.getOrderByField().equals(headerName)) {
							if (!dgQuery.isAsc(headerName)){
								content+= ((char) 8595);
							}else{
								content+= ((char) 8593);
							}
						}
					}
					text.setContent(content);
				}
			}
		
	}

	@Override
	public Vector<LinkedHashMap<String, Object>> renderBody(Component grid) throws Exception {

		boolean allChecked = true;

		rowAdapter.getLinkObjectDiv().clear();
		
		Rows rows = new Rows();
		
		
		/*
		if(null!=dgModel.getHeight()){
		    String height=dgModel.getHeight();
			if(height.contains("px")){
				height=height.replace("px", "");	
				height=(Integer.parseInt(height)-80)+"px";
				rows.setHeight(height);		
				String style="border-collapse:collapse;height:"+height;
				rows.setStyle(style);
			}else{ rows.setHeight(dgModel.getHeight());
			rows.setStyle("border-collapse:collapse;");
			}
		}else 
		*/
		rows.setStyle("border-collapse:collapse;");
		
		
		rows.setParent(grid);

		
		Vector<LinkedHashMap<String, Object>> page = dgModel.getPage();
		int index=0;
		for (LinkedHashMap<String, Object> rowmodel : page) {

			getRowAdapter().setRow(getDgModel(), rowmodel);

			Row row = new Row();
			row.setAttribute("container", grid);
			row.setParent(rows);
			if(null!=dgModel.getDataTableNameId())
				row.setAttribute("dataTableName", dgModel.getDataTableNameId());
				

			if (SELECTOR_CHECKBOX == selectorType) {
				Checkbox checkbox = new Checkbox();
				//checkbox.setZclass("fieldValue");
				checkbox.setParent(row);
				checkbox.setAttribute("container", row);
				checkbox.addEventListener("onCheck", this);
				LinkedHashMap<String, Object> id = getRowAdapter().getRow();
				
				if (null != id){
					checkbox.setAttribute("ROW_ID", id);
				}
				checkInitialChecked(id);
				checkbox.setChecked(selectionMan.isChecked(id));

				if (!checkbox.isChecked()){
					allChecked = false;
				}
				applyTrSelectionStyle(checkbox, selectionMan.isChecked(id));
				VectorCheckBox.add(checkbox);
			}
			if (SELECTOR_RADIO == selectorType) {
				Radio radio = new Radio();
				radio.setParent(row);
				radio.addEventListener("onCheck", this);
				radio.setAttribute("container", row);

				LinkedHashMap<String, Object>  id = getRowAdapter().getRow();
				if (null != id){
					radio.setAttribute("ROW_ID", id);
				}
				checkInitialChecked(id);
				radio.setChecked(selectionMan.isChecked(id));

			}
			for (String columnName : dgModel.getDgQuery().getColumnNames()) {
				if (dgModel.getHiddenColumns().contains(columnName.toUpperCase())){
					continue;
				}	
				if (null == getDgModel().getHeaderLabels() || null != getDgModel().getHeaderLabels().get(columnName)) {
					Div div = new Div();
					div.setParent(row);
					div.setHflex("1");
					div.setVflex("1");
					div.setAttribute("container", row);
					div.setAttribute("index", index++);
					rowAdapter.renderCell(div, columnName, this);
				}
			}
		}
		
		pageCheckbox.setChecked(allChecked);
	
		return page;
	}

	

	@Override
	public void applyTrSelectionStyle(Component comp, boolean isChecked) {
	}
}
