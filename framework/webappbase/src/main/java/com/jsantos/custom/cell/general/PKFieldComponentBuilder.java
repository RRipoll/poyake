package com.jsantos.custom.cell.general;

import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;

import com.jsantos.common.model.EditMode;
import com.jsantos.custom.detail.IDetailContainer;
import com.jsantos.factory.DTOFactory;
import com.jsantos.factory.permission.PermissionFactory;
import com.jsantos.gui.DesktopHelper;
import com.jsantos.gui.detail.DetailContainerProvider;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;

public class PKFieldComponentBuilder extends PrimaryKeyGridCellBuilder{
	
	public PKFieldComponentBuilder(MTField field) {
		super(field);
	}

	@Override
	public Component buildGridComponent(MTField mtField, Object value, IDetachedRecord values,Locale locale) {
		Component comp = super.buildGridComponent(mtField, value, values,locale);
		if(PermissionFactory.getProvider().hasAnyPermission(permissionValue)) {
		 	comp.addEventListener(Events.ON_CLICK, new CellEventListener(comp, value));
		}
		return comp;
	}

	public class CellEventListener implements EventListener<Event>{
		Component comp;
		Object value;
		
		public CellEventListener(Component comp, Object value) {
			this.comp = comp;
			this.value= value;
		}
		
		public void onEvent(Event event) throws Exception {
			try {
				
				event.stopPropagation();
				
				IDetailContainer container;
				MTTable targetTable;
				
				if(null==value)return;
				
				if(null!=getField().getForeignKey())
					targetTable=getField().getForeignKey().getRealFKTOTable();
				else 
					targetTable=getField().getTable().getRealFKTOTable();
				
				container=DetailContainerProvider.getDetailContainer(targetTable);
				
				if(targetTable.getPatterns().contains("AutoHistory") ) {
					AutoHistoryDetachedRecord dr= new AutoHistoryDetachedRecord(targetTable,true,value);
					container.setDetachedRecord(dr);
				}else
					container.setDetachedRecord(DTOFactory.get(targetTable).findByPk(value));
				
				container.setParent(DesktopHelper.getRootComponent());
				container.buildAndShowComponent(EditMode.AUTO);
			}
			catch (Throwable e) {
				e.printStackTrace();
				throw e;
			}
		}
	}
}