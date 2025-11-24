package com.etantolling.testrunner.test.zkweb.datagrid3;

import java.sql.SQLException;

import org.zkoss.zk.ui.HtmlBasedComponent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import com.etantolling.testrunner.test.core.metadata.MTTable;

public class BasicRowAdapterForMTTable extends BasicRowAdapter{
	MTTable table;

	public BasicRowAdapterForMTTable(MTTable table) {
		this.table = table;
	}
	
	@Override
	public void renderCell(HtmlBasedComponent div, String columnName, EventListener<Event> eventListener) throws SQLException {

		super.renderCell(div, columnName, eventListener);
		div.setStyle("float:left;text-weight:bold;padding:0px 0px 0px 4px;cursor:pointer;vertical-align:middle;");
		div.setAttribute("CELL_CLICK_INFO", row.get(table.getPrimaryKey().getName()));
		div.addEventListener(Events.ON_CLICK, eventListener);
	}

	@Override
	public String getRowId() throws SQLException {
		return table.getPrimaryKey().getName();
	}
}