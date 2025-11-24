package com.jsantos.screen.systemadmin.users;

import org.zkoss.zk.ui.Component;

import com.jsantos.gui.datagrid4.EntityGrid;
import com.jsantos.gui.datagrid4.FilterGroup;
import com.jsantos.gui.filteredgrid.FilteredGrid;
import com.jsantos.metadata.MTAuditData;

public class UserSearch {
	
	public UserSearch() {
		super();
	}

	Component filterDiv;
	Component gridDiv;
	EntityGrid entityGrid;
	FilterGroup filterGrid;
	
	public void buildGrid(Component comp)  throws Exception{
		FilteredGrid filteredGrid = new FilteredGrid(MTAuditData.INPUTUSER, comp);
		filteredGrid.setHeaderLabel("Users");
		filteredGrid.build();
	}
}