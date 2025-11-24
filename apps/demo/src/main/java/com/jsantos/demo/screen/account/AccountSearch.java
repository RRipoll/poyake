package com.jsantos.demo.screen.account;

import org.zkoss.zk.ui.Component;

import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.gui.datagrid4.EntityGrid;
import com.jsantos.gui.filteredgrid.FilteredGrid;
import com.jsantos.metadata.MT;
import com.jsantos.metadata.crm.MTTableVCUSTOMERSEARCH;

public class AccountSearch {
	
	
	public void buildGrid(Component comp) throws Exception{
		FilteredGrid filteredGrid = new FilteredGrid(MT.VCUSTOMERSEARCH, comp);
		filteredGrid.init();
		EntityGrid entityGrid = filteredGrid.getEntityGrid().init();
		GridColumnConfiguration.get(entityGrid.getSettingDTO().getColumnConfigurations(),MTTableVCUSTOMERSEARCH.FIRSTNAME).setHidden(true);
		GridColumnConfiguration.get(entityGrid.getSettingDTO().getColumnConfigurations(),MTTableVCUSTOMERSEARCH.LASTNAMEORCOMPANYNAME).setHidden(true);
		GridColumnConfiguration.get(entityGrid.getSettingDTO().getColumnConfigurations(),MTTableVCUSTOMERSEARCH.LASTINVOICEID).setHidden(true);
		filteredGrid.build();
	}
}
