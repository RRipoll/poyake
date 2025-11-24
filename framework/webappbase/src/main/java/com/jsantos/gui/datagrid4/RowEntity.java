package com.jsantos.gui.datagrid4;

import org.zkoss.zhtml.Div;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Clients;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.model.conf.GridColumnConfiguration;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;

public class RowEntity implements IEntity{
	
	private ISelectionMan selectionMan; 
	Div topComponent;
	SettingDTO settingDTO;
	
	public RowEntity(ISelectionMan selectionMan,   SettingDTO settingDTO) {
		super();
		this.selectionMan = selectionMan;
		this.settingDTO = settingDTO;
	}

	public Component build(Component row, IDetachedRecord datarecord){
		
		
		for (GridColumnConfiguration config:settingDTO.getColumnConfigurations()) {
			if (config.isActive()) {
				MTField field = config.getMtField();
				if(null==field) {
					System.out.println(settingDTO.getaSName()+ "DataGrid Configuration is obsolete "+config.getName()+ " don't exists");
					Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null, 2000);
					continue;
				}
				Component builder =CellEntity.getCellBuilder(field, datarecord);
				builder.setParent(row);
				if(config.isHidden())builder.setVisible(!config.isHidden());
			}
		}
		return row;
	}
	
	

}
