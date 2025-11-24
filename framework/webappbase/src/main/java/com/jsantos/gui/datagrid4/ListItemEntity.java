package com.jsantos.gui.datagrid4;

import org.zkoss.zhtml.Div;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Radio;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.gui.CustomEvents;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.AttributeConstants;

public class ListItemEntity implements IEntity{

	private ISelectionMan selectionMan; 
	GridSelectorType selectorType;
	Div topComponent;
	
	SettingDTO settingDTO;

	
	public ListItemEntity(ISelectionMan selectionMan, GridSelectorType selectorType, Div topComponent, SettingDTO settingDTO) {
		super();
		this.selectionMan = selectionMan;
		this.selectorType = selectorType;
		this.topComponent = topComponent;
		this.settingDTO = settingDTO;
	}

	public Component build(Component row, IDetachedRecord datarecord){
		buildSelectorColumn(row,datarecord);
		for (GridColumnConfiguration config:settingDTO.getColumnConfigurations()) {
			if (config.isActive()) {
				MTField field = config.getMtField();
				if(null==field) {
					System.out.println(settingDTO.getaSName()+ "DataGrid Configuration is obsolete "+config.getName()+ " don't exists");
					Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null, 2000);
					continue;
				}
				Listcell cell= new Listcell();
				cell.setParent(row);
				MTField drField= datarecord.getTable().getField(field.getName());
				if(null!=drField) {
					Component builder =CellEntity.getCellBuilder(drField, datarecord);
					builder.setParent(cell);
					if(config.isHidden())builder.setVisible(config.isHidden());
					}
				}
		}
		return row;
	}
	
	void buildSelectorColumn(Component parent,IDetachedRecord dr) {
		//DetachedRecord dr=(DetachedRecord) row.getAttribute(AttributeConstants.DETACHED_RECORD);
		if (GridSelectorType.CHECKBOX == selectorType) {
			Listcell cell= new Listcell();
			cell.setParent(parent);
			Checkbox checkbox = new Checkbox();
			checkbox.setWidth("45px");
			checkbox.setParent(cell);
			checkbox.setAttribute(AttributeConstants.DETACHED_RECORD,dr);
			checkbox.setChecked(selectionMan.isChecked(dr));
			checkbox.addEventListener(Events.ON_CHECK, this::checkboxChecked);
		}
		if (GridSelectorType.RADIO == selectorType) {
			Listcell cell= new Listcell();
			cell.setParent(parent);
			Radio radio = new Radio();
			radio.setWidth("45px");
			radio.setParent(cell);
			radio.setAttribute(AttributeConstants.DETACHED_RECORD,dr);
			radio.addEventListener(Events.ON_CHECK, this::radioboxChecked);
			radio.setChecked(selectionMan.isChecked(dr));
		}
	}
	
	public void checkboxChecked(Event event) {

		DetachedRecord id = (DetachedRecord) event.getTarget().getAttribute(AttributeConstants.DETACHED_RECORD);
			
			if (null != id) {
				selectionMan.set( id,((CheckEvent) event).isChecked());
				Events.sendEvent(CustomEvents.ON_SELECTORCLICK, topComponent, event.getTarget());
			}
	}
	
	public void radioboxChecked(Event event) {
		DetachedRecord id = (DetachedRecord) event.getTarget().getAttribute(AttributeConstants.DETACHED_RECORD);
		selectionMan.setSingleSelection(id);
		Events.sendEvent(CustomEvents.ON_SELECTORCLICK, topComponent, event.getTarget());
	}
}
