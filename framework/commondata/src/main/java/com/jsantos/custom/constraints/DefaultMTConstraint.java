package com.jsantos.custom.constraints;

import java.util.List;

import com.jsantos.common.constraint.ErrorsConstants;
import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.constraint.ValidationError;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTField;

public class DefaultMTConstraint implements IConstraintsBuilder {
	
	@Override
	public <T>ListValues<IValidationError> validate(MTField mtField, Object value, MTMapValues<T> values) {
		ListValues<IValidationError> errors= new ListValues<IValidationError>();
		
		if(!mtField.isNullable() && null==mtField.getDefaultValue() && !mtField.isPrimaryKey()) {
			if(null==value || value.equals("") || (value instanceof List && ((List)value).isEmpty())) {
				ValidationError ve= new ValidationError();
				ve.setMessageCode(ErrorsConstants.NOT_NULABLE);
				ve.getParameters().add(mtField.getLabel());
				errors.add(ve);
			}
		}
		return errors;
	}

	

	
}
