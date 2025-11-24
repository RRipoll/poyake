package com.jsantos.custom.cell;

import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Checkbox;

import com.jsantos.custom.cell.general.BitCellBuilder;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class SelectedEventBuilder implements IGridCellBuilder {

	@Override
	public    MTDataType forModelType() {
		return MTDataTypes.EVENTSELECTED;
		};
	
	
	IDetachedRecord values;
	MTField mtField;
	Checkbox comp;
	
	@Override
	public Component buildGridComponent(MTField mtField, Object value, IDetachedRecord values, Locale locale) {
		this.values=values;
		this.mtField=mtField;
		BitCellBuilder bitCell= new BitCellBuilder();
		comp= (Checkbox) bitCell.buildGridComponent(mtField, value, values, locale);
		comp.setDisabled(false);
		comp.addEventListener(Events.ON_CHECK, this::check);
		return comp;
		
	}
	
	void check(Event evn) {
		values.getUpdates().set(mtField, comp.isChecked()?1:0);
		//values.set(mtField, comp.isChecked()?1:0);
	}

}
