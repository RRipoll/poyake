package com.etantolling.testrunner.test.zkweb.datagrid3;

import java.sql.SQLException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Html;

import com.etantolling.testrunner.test.core.utils.DataFormatter;


public class BasicRowAdapterEventId extends BasicRowAdapter{

	private int eventColumn = 0;
	public BasicRowAdapterEventId() {}
	
	public BasicRowAdapterEventId(int eventColumn) {
		this.eventColumn = eventColumn;
	}
	
	@Override
	public void renderCell(HtmlBasedComponent div, String columnName, EventListener<Event> eventListener) throws SQLException {

		if(columnName.equals(row.keySet().toArray()[this.eventColumn])){
			div.setSclass("fieldValue");
			div.setStyle("float:left;text-weight:bold;padding:0px 0px 0px 4px;vertical-align:middle;");
			Html html = new Html(DataFormatter.formatValue(row.get(columnName),dgModel.getColumnFormat().get(columnName)));
			html.setStyle("font-weight: normal;font-style:italic;color:blue;");
			html.setParent(div);
			div.setStyle(div.getStyle()+"cursor:pointer;");
			div.setAttribute("CELL_CLICK_INFO", row);
			div.addEventListener(Events.ON_CLICK, eventListener);
			div.addEventListener(Events.ON_DOUBLE_CLICK, eventListener);
			if(null!=div.getAttribute("container"))((Component)div.getAttribute("container")).setAttribute("CELL_CLICK_INFO", row);
		
		}else{
			super.renderCell(div, columnName, eventListener);
		}
	}

	protected Boolean haveDetailPermission(EventListener<Event> comp){
		return true;
	}
}
