package com.jsantos.custom.trigger;

import java.util.Map.Entry;

import com.jsantos.common.constraint.ConstraintsComponentProvider;
import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.constraint.UIConstraints;
import com.jsantos.common.util.ListValues;
import com.jsantos.custom.constraints.DefaultMTConstraint;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ConstraintsException;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTrigger;

public class ConstraintsTrigger extends MTTrigger {

	@Override
	public void beforeInsert(IDetachedRecord dr) {
		ListValues<IValidationError> errors = new ListValues<>();
		for (Entry<MTField, Object> element : dr.getCopyValues().entrySet()) {
			for (IConstraintsBuilder builder : ConstraintsComponentProvider.getConstraintsComponent(element.getKey())) {
				if(builder  instanceof UIConstraints) 
					continue;
				if((null == builder &&(!element.getKey().isNullable() || null!=element.getKey().getLength()))) builder=new DefaultMTConstraint();
				if (null != builder)
					errors.addAll(builder.validate(element.getKey(), element.getValue(), dr.getCopyValues()));
			}
		}
		if (!errors.isEmpty())
			throw new ConstraintsException(ApiError.VALIDATION_ERROR, errors);

	}
}
