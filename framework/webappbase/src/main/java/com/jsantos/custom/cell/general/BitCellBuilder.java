package com.jsantos.custom.cell.general;

import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Checkbox;

import com.jsantos.custom.cell.IGridCellBuilder;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class BitCellBuilder  implements IGridCellBuilder {

	@Override
	public Component buildGridComponent(MTField mtField, Object value, IDetachedRecord values, Locale locale) {
		if(null==value )return null;
		boolean booleanValue;
		if (value instanceof Boolean)
			booleanValue=(boolean) value;
		else
			booleanValue = "1".equals(value.toString());
		//if(!booleanValue)return null;
		Checkbox comp= new Checkbox();
		comp.setChecked(booleanValue);
		comp.setDisabled(true);
		return comp ;
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.BIT;
	}


}
