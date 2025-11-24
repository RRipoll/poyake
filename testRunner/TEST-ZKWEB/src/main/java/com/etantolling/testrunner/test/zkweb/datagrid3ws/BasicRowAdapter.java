package com.etantolling.testrunner.test.zkweb.datagrid3ws;

import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Div;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Html;

import com.etantolling.testrunner.test.core.utils.DataFormatter;

public class BasicRowAdapter {

	protected LinkedHashMap<String, Object> row;
	protected DataGridModel dgModel;

	protected LinkedHashMap<LinkedHashMap<String, Object>, LinkedHashMap<String, Div>> linkObjectDiv=new LinkedHashMap<LinkedHashMap<String, Object>, LinkedHashMap<String, Div>>();
	
	public BasicRowAdapter() {
	}

	public void setRow(DataGridModel dgModel, LinkedHashMap<String, Object> row) {
		this.row = row;
		this.dgModel = dgModel;
	}

	public String getRowId() throws SQLException {
		return row.get(row.keySet().toArray()[0])+"";
	}
	public LinkedHashMap<String, Object> getRow() throws SQLException {
		return row;
	}
	
	public void renderCell(Div div, String columnName, EventListener<Event> eventListener) throws Exception {
		
		if(linkObjectDiv.containsKey(row)){
			LinkedHashMap<String, Div> r= linkObjectDiv.get(row);
			r.put(columnName, div);
		}else{
			LinkedHashMap<String, Div> r= new LinkedHashMap<String, Div>();
			r.put(columnName, div);
			linkObjectDiv.put(row, r);
		}
		
		div.setSclass("fieldValue");
		
		String css="text-weight:bold;padding:0px 0px 0px 4px;";
		String alignCss="float:left;";
		
		if(null!=dgModel.getColumnAlign().get(columnName)){
			String align=dgModel.getColumnAlign().get(columnName);
			css+="float:"+align+";";
		}else {css+=alignCss;}
		
		div.setStyle(css);
		if (!dgModel.dgQuery.columnNames.contains(columnName)){
			throw new RuntimeException("Column name '" + columnName + "' does not exist in query ");
		}
		Html html = new Html(DataFormatter.formatValue(row.get(columnName),dgModel.getColumnFormat().get(columnName)));
		html.setParent(div);
	}

	public void formatTd(int nCol, Hbox hbox) {
	}

	public LinkedHashMap<LinkedHashMap<String, Object>, LinkedHashMap<String, Div>> getLinkObjectDiv() {
		return linkObjectDiv;
	}
	
	public void reset(){
	}
}