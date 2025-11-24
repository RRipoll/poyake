package com.jsantos.gui.objectselector.foldertree;

import org.zkoss.zhtml.Div;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Label;

import com.jsantos.common.model.SettingDTO;
import com.jsantos.commondata.util.DefaultRecordDescription;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.datagrid4.IEntity;
import com.jsantos.orm.dbstatement.IDetachedRecord;

public class TreeEntity implements IEntity {
	
	Div topComponent;
	SettingDTO settingDTO;

	public TreeEntity( SettingDTO settingDTO) {
		super();
		this.settingDTO = settingDTO;
	}

	@Override
	public Component build(Component row, IDetachedRecord datarecord) {
        row.getChildren().clear();
        
        String description=  DefaultRecordDescription.getDescription(datarecord, LocaleFactory.getProvider().getLocale());
        
        return new Label(description);
        
        /*
        for (GridColumnConfiguration config : settingDTO.getColumnConfigurations()) {
			if (config.isActive()) {
				MTField field = config.getMtField();
				if (null == field) {
					System.out.println(settingDTO.getaSName() + "DataGrid Configuration is obsolete " + config.getName()
							+ " don't exists");
					Clients.showNotification("Constraints not acomplish", Clients.NOTIFICATION_TYPE_ERROR, null, null,
							2000);
					continue;
				}
				Component builder = CellEntity.getCellBuilder(field, datarecord);
				builder.setParent(row);
				if (config.isHidden())
					builder.setVisible(!config.isHidden());
			}
		}
        */
        
        
	//	return row;
	}
}

