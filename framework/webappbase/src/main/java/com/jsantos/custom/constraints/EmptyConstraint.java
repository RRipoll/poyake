package com.jsantos.custom.constraints;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.CustomConstraint;
import org.zkoss.zul.SimpleConstraint;

import com.jsantos.gui.constraints.IMTConstraint;

public class EmptyConstraint extends SimpleConstraint implements CustomConstraint,IMTConstraint{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyConstraint() {
		super(SimpleConstraint.NO_EMPTY);
	}

	@Override
	public void validate(Component comp, Object value) throws WrongValueException {
		
	}

	public void showCustomError(Component comp, WrongValueException ex) {

      }

	
}
