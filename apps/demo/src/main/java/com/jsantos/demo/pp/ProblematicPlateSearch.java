package com.jsantos.demo.pp;

import org.zkoss.zk.ui.Component;

import com.jsantos.gui.filteredgrid.FilteredGrid;
import com.jsantos.metadata.MT;

public class ProblematicPlateSearch {
	public void buildGrid(Component comp){
		
		FilteredGrid filteredGrid = new FilteredGrid(MT.VPROBLEMATICPLATE, comp);
		filteredGrid.init();
		filteredGrid.build();
	}

}
