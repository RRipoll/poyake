package com.jsantos.custom;

import com.jsantos.common.constraint.ErrorsConstants;
import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.constraint.ValidationError;
import com.jsantos.common.model.SettingDTO;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.metadata.MTDataGridSettingData;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.service.DatagridSettingExtendedDAO;

public class JsonConstraint implements IConstraintsBuilder{

	@Override
	public <T> ListValues<IValidationError> validate(MTField mtField, Object value, MTMapValues<T> values) {
		ListValues<IValidationError> errors= new ListValues<IValidationError>();
		try {
			SettingDTO settingDTO= (SettingDTO)value;
			String aSName=settingDTO.getaSName().toString();
			String table=settingDTO.getDataTableName().toString();
			
			MTBase.getTable(table).toString();
			MTTable mtTable=MTBase.getTable(table);
			settingDTO.setMtTable(mtTable);
			
			DatagridSettingExtendedDAO.setMTFieldToSetting(settingDTO);
			
			
		} catch (Exception e) {
			ValidationError ve= new ValidationError();
			ve.setMessageCode(ErrorsConstants.DATAGRID_WAS_WRONG);
			ve.getParameters().add(mtField.getLabel());
			errors.add(ve);
		}
		
	
	return errors;
		
	}

	@Override
	public MTField forField() {
		return MTDataGridSettingData.DATAGRIDSETTING.DATA;
	}
	
}
