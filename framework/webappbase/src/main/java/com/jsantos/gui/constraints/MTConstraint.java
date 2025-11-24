package com.jsantos.gui.constraints;

import java.util.List;

import org.zkoss.zhtml.Div;
import org.zkoss.zhtml.Label;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.CustomConstraint;
import org.zkoss.zul.Space;

import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ConstraintsException;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.AttributeConstants;

public class MTConstraint<T>  implements Constraint, CustomConstraint,IMTConstraint{
	
	
	MTField mtField;
	MTMapValues<T> records;
	Div div;
	ListValues<IConstraintsBuilder> constraints= new ListValues<IConstraintsBuilder>();
	Text text;
	
	
	@Override
	public void showCustomError(Component comp, WrongValueException ex) {
		List<IValidationError> errors=(ListValues<IValidationError>) comp.getAttribute(AttributeConstants.VALIDATION_ERRORS);
		
			div.getChildren().clear();
			if(null!=ex) {
				if(null!=errors && !errors.isEmpty())
					for (IValidationError validationError : errors) {
						Label errmsg= new Label();
						errmsg.setParent(div); 
						String message= RenderedConstraint.renderedValue(validationError);
						if(message.isEmpty())message=validationError.getMessageCode();
						text=new Text(message);
						text.setParent(errmsg);
						new Space().setParent(div); 
					}
				else if(null!=ex && null!=ex.getMessage()){
					Label errmsg= new Label();
					errmsg.setParent(div); 
					text=new Text(ex.getMessage());
					text.setParent(errmsg);
				}
			}
	}

	public MTConstraint(Component comp,MTField mtField, MTMapValues<T> records) {
		super();
		div= new Div();
		this.mtField=mtField;
		this.records=records;
		this.mtField=mtField;
		div.setSclass("invalid-feedback");
		div.setStyle("display:contents");
		div.setParent(comp.getParent());
	}

	@Override
	public void validate(Component comp, Object value) throws WrongValueException {
		
		div.getChildren().clear();
		comp.setAttribute(AttributeConstants.VALIDATE_RECORD, records);
		comp.removeAttribute(AttributeConstants.VALIDATION_ERRORS);
		ListValues<IValidationError> errors= new ListValues<IValidationError>();
		for (IConstraintsBuilder constraint : constraints) {
					errors.addAll(constraint.validate(mtField, value, records));
			}
		if(null!=errors && !errors.isEmpty()) {
			comp.setAttribute(AttributeConstants.VALIDATION_ERRORS, errors);
			showCustomError(comp, new WrongValueException(comp, errors.get(0).getMessageCode()));
			throw new ConstraintsException(ApiError.CONSTRAINT_NOT_ACOMPLISH, errors);
		}
	}

	public void setConstraints(IConstraintsBuilder constraint) {
		constraints.add(constraint);
	}
}
