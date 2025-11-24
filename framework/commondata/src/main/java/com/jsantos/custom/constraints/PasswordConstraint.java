package com.jsantos.custom.constraints;

import com.jsantos.common.constraint.ErrorsConstants;
import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.constraint.ValidationError;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class PasswordConstraint implements IConstraintsBuilder {

	
	public static final int NULL = 0;
	public static final int VERYWEAK = 1;
	public static final int MEDIUM = 2;
	public static final int STRONG = 3;
	public static final int STRONGEST = 4;
	
	@Override
	public <T>ListValues<IValidationError> validate(MTField mtField, Object value, MTMapValues<T> values) {
		ListValues<IValidationError> errors= new ListValues<IValidationError>();
		
			if(strengthMeasure(value.toString())<MEDIUM) {
				
				ValidationError ve= new ValidationError();
				ve.setMessageCode(ErrorsConstants.PASSWORD);
				ve.getParameters().add(mtField.getLabel());
				ve.getParameters().add(strengthMeasure(value.toString()));
				errors.add(ve);
			
		}
			
			
		return errors;
	}

	public Integer strengthMeasure(String text) {
	    int score = 0;
	    if (text.length() > 0)
	        score++;
	 
	    if (text.length() > 6)
	        score++;
	 
	    if ((text.matches("/[a-z]/")) && (text.matches("/[A-Z]/")))
	        score++;
	 
	    if (text.matches("/\\d+/"))
	        score++;
	 
	    if (text.matches("/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/"))
	        score++;
	 
	    if (text.length() > 12)
	        score++;
	 
	    if (text.length() == 0)
	        score = 0;
	 
	    return score;
	}
	
	
	


	@Override
	public MTDataType forModelType() {
		return MTDataTypes.PASSWORD;
	}
}

