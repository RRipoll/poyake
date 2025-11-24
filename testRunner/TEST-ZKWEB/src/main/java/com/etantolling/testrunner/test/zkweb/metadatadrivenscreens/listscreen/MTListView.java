package com.etantolling.testrunner.test.zkweb.metadatadrivenscreens.listscreen;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Window;

import com.etantolling.testrunner.test.zkweb.datagrid3.DataTable;
import com.etantolling.testrunner.test.zkweb.datagrid3.DataTableCompressed;


@SuppressWarnings("serial")
public class MTListView extends Window{

	private EventListener<Event> eventListener = null;
	private DataTableCompressed dataGrid = null;
	private Component filterComponent;
	private Component content;
	private String sql;
	
	public MTListView(EventListener<Event> eventListener,  String sql, Component content, Component filterComponent) {
		this.eventListener = eventListener;
		this.content = content;
		this.filterComponent = filterComponent;
		
		this.sql=sql;
		doLayout();
	}

	public void doLayout() {
		dataGrid = new DataTableCompressed(sql, filterComponent, content, eventListener);
		dataGrid.setSelector(DataTable.SELECTOR_CHECKBOX);
		//dataGrid.setPaging(DataTable.PAGING_GOOGLE);
	}

	public DataTableCompressed getDataGrid() {
		return dataGrid;
	}
}