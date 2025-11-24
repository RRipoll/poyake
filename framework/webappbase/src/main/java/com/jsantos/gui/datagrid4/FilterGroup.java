package com.jsantos.gui.datagrid4;

import java.util.Collections;
import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.FilterConfiguration;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.filter.FilterFieldComponentProvider;
import com.jsantos.custom.filter.IFilterComponent;
import com.jsantos.gui.zkutil.ComponentTreeTransverser;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.AttributeConstants;
import com.jsantos.search.core.services.SqlFacade;
import com.jsantos.search.model.ParameterDTO;
import com.jsantos.search.model.parameter.BlockItem;

public class FilterGroup {
	
	SettingDTO settingDTO;
	Component parent;
	ListValues<Object> values;
	
	public FilterGroup(SettingDTO settingDTO,Component parent) {
		super();
		this.settingDTO=settingDTO;
		this.parent=parent;
	}
	
	public void reset() throws Exception {
		buildFilter();
	}
	
	public void buildFilter(){
		
		parent.getChildren().clear();

		Grid grid = new Grid();
		grid.setParent(parent);
		Columns columns = new Columns();
		columns.setParent(grid);
		Rows rows = new Rows();
		rows.setParent(grid);
		
		for (FilterConfiguration config:settingDTO.getFilterConfigurations()) { 
			MTField mTField=config.getMtField();
			if(null==mTField) {
				System.out.println(settingDTO.getaSName()+ "DataGrid Configuration is obsolete "+config.getName()+ " don't exists");
				Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null, 2000);
				continue;
			}
			if(!config.isHidden()) {
				Component filter=FilterFieldComponentProvider.buildAndInitializeFilterComponent(config, values);
				filter.setAttribute(AttributeConstants.FILTER_CONFIGURATION, config);
				Row div = new Row();
				div.setParent(rows);
				filter.setParent(div);
				div.setAttribute(AttributeConstants.FILTER_CONFIGURATION, config);
				div.setDraggable("true");
				div.setDroppable("true");
				div.addEventListener(Events.ON_DROP, this::moveFilter);
			}
		}
	}
	
	public String getWhereClause(MapValues<Object>parameters) {
		ListValues<BlockItem>blocks= new ListValues<BlockItem>();
		
		Vector<Component> components = ComponentTreeTransverser.getComponentsByAttributeValue(parent, "type",AttributeConstants.FILTER);
		String whereClause="";
		for (Component component : components) {
			BlockItem block=((IFilterComponent)component.getAttribute(AttributeConstants.EDITOR)).generateBlockItem();
			if(null!=block)
			 blocks.add(block);
		}
		whereClause= SqlFacade.createWhereClause(settingDTO.getFilterConfigurations(), new ParameterDTO().setAnd(blocks), parameters);
		return whereClause;
	}
	
	public void moveFilter(Event event) throws Exception {
		DropEvent dropEvent=(DropEvent)event;
		Object target= event.getTarget().getAttribute(AttributeConstants.FILTER_CONFIGURATION);
		Object dragged= dropEvent.getDragged().getAttribute(AttributeConstants.FILTER_CONFIGURATION);
	  
	   int targetIndex=settingDTO.getFilterConfigurations().indexOf(target);
	   int draggedIndex=settingDTO.getFilterConfigurations().indexOf(dragged);
	   
	   if(targetIndex<draggedIndex) {
		   for (int j = draggedIndex; j > targetIndex; j--) {
			   Collections.swap(settingDTO.getFilterConfigurations(), j, j-1);}
		}
	   else {
		   for (int j = draggedIndex; j < targetIndex; j++) {
			   Collections.swap(settingDTO.getFilterConfigurations(), j+1, j);}
	   }
	   
	   buildFilter();
	}
	
	public Component getParent() {
		return parent;
	}

	public void setParent(Component parent) {
		this.parent = parent;
	}

	public ListValues<Object> getValues() {
		return values;
	}

	public void setValues(ListValues<Object> values) {
		this.values = values;
	}
    
}
