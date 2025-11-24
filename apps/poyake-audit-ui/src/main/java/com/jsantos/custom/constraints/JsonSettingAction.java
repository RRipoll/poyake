package com.jsantos.custom.constraints;

import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.constraint.UIConstraints;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.factory.dataSetting.DataSettingFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.metadata.MTDataGridSettingData;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;

public class JsonSettingAction implements IConstraintsBuilder,UIConstraints{

	@Override
	public <T> ListValues<IValidationError> validate(MTField mtField, Object value, MTMapValues<T> values) {
		Object data=values.get(MTDataGridSettingData.DATAGRIDSETTING.DATA);
		if(null!=value && null==((IMTComponent)data).getValue()) {
			if(null!=MTBase.getTable(value.toString())) {
				SettingDTO setting=DataSettingFactory.getProvider().getSetting(value.toString(),null, LocaleFactory.getProvider().getLocale());
				((IMTComponent)data).setValue(setting);
				
			}
		}
		return null;
	}
	
	@Override
	public MTField forField() {
		return MTDataGridSettingData.DATAGRIDSETTING.SEARCHNAME;
	}
}
