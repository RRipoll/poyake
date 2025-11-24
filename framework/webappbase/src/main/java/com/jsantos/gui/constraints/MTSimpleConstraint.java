package com.jsantos.gui.constraints;

import java.util.List;
import java.util.regex.Pattern;

import org.zkoss.zhtml.Div;
import org.zkoss.zhtml.Label;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.CustomConstraint;
import org.zkoss.zul.SimpleConstraint;

import com.jsantos.common.constraint.IConstraintsBuilder;
import com.jsantos.common.constraint.ValidationError;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.orm.exceptions.IValidationError;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.AttributeConstants;

public class MTSimpleConstraint extends SimpleConstraint implements  Constraint, CustomConstraint,IConstraintsBuilder{

	Div div;
	
	

	
	private static final long serialVersionUID = 1L;

	
	public MTSimpleConstraint() {
		super("");
	}

	
	
	public MTSimpleConstraint(Component comp,int flags, Pattern regex, String errmsg) {
		super(flags, regex, errmsg);
		init(comp);
	}
	
	public MTSimpleConstraint(Component comp,String regex, String errmsg) {
		super(regex, errmsg);
		init(comp);}
	
	public MTSimpleConstraint(Component comp,int flags, String regex, String errmsg) {
		super(flags, regex, errmsg);init(comp);
	}
	
	public MTSimpleConstraint(Component comp,int flags, String errmsg) {
		super(flags, errmsg);init(comp);
	}
	
	public MTSimpleConstraint(Component comp,int flags) {
		super(flags);init(comp);
	}
	
	public MTSimpleConstraint(Component comp,String constraint) {
		super(constraint);init(comp);
	}

	public MTSimpleConstraint(Component comp,Pattern regex, String errmsg) {
		super(regex, errmsg);init(comp);
	}

	@Override
	public void showCustomError(Component comp, WrongValueException ex) {
		List<IValidationError> errors=(List<IValidationError>) comp.getAttribute(AttributeConstants.VALIDATION_ERRORS);
		//div.getChildren().clear();
		
			div.getChildren().clear();
			if(null!=errors && !errors.isEmpty())
				for (IValidationError validationError : errors) {
					Label errmsg= new Label();
					errmsg.setParent(div); 
					Text text=new Text(RenderedConstraint.renderedValue(validationError));
					text.setParent(errmsg);
				}
			else if(null!=ex && null!=ex.getMessage()){
				Label errmsg= new Label();
				errmsg.setParent(div); 
				Text text=new Text(ex.getMessage());
				text.setParent(errmsg);
			}
	}

	void init(Component comp) {
		div= new Div();
		div.setSclass("invalid-feedback");
		div.setStyle("display:contents");
		div.setParent(comp.getParent());
	}
	
	
	@Override
	public <T> ListValues<IValidationError> validate(MTField mtField, Object value, MTMapValues<T> values) {
		ListValues<IValidationError> errors= new ListValues<IValidationError>();
		try {
			super.validate(div, value);
		} catch (WrongValueException e) {
			ValidationError ve= new ValidationError();
			ve.setMessageCode(e.getMessage());
			ve.getParameters().add(mtField.getLabel());
			errors.add(ve);
		}
		
		return errors;
	}
	
	
}
