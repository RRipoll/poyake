package com.jsantos.gui.constraints;

import org.zkoss.util.resource.Labels;

import com.jsantos.common.constraint.ValidationError;
import com.jsantos.orm.exceptions.IValidationError;

public class RenderedConstraint extends ValidationError{

	
	public static  String renderedValue(IValidationError validationError){
		String renderedValue= Labels.getLabel(validationError.getMessageCode(), validationError.getParameters().toArray());
		if(null==renderedValue)
			renderedValue=validationError.getMessageCode();
		return renderedValue;
	}

}
