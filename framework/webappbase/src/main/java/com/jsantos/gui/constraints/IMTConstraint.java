package com.jsantos.gui.constraints;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Constraint;
import org.zkoss.zul.CustomConstraint;

public interface IMTConstraint extends CustomConstraint,Constraint{
	
	public void showCustomError(Component comp, WrongValueException ex);
	public void validate(Component comp, Object value) throws WrongValueException;
}
