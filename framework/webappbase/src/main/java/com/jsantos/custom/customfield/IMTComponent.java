package com.jsantos.custom.customfield;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;

import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public interface IMTComponent  extends Component{
	
	public void 	setLabel(String label);
	public String 	getLabel();
	
	public void 	setMTField(MTField mtField);
	public MTField 	getMTField();

	public void 	setField(String field);
	public String 	getField();

	public void 	setReadonly(boolean readOnly) ;

	public Object 	getValue();
	public void 	setValue(Object value);

	public void 	setDetachedRecord(IDetachedRecord dRecord);

	public boolean 	isUpdated();
	public void setUpdated(boolean isUpdated);
	
	public default MTDataType forModelType() {return null;};
	public default MTField forField(){return null;}
    public default MTTable forPKTable(){return null;}
	
	public IMTConstraint getConstraints();
	void setConstraint(IMTConstraint constraint);
	public default void validate(Event event) throws WrongValueException {
		if(null!=getConstraints())
			getConstraints().validate(this, getValue());
	}

	public Component initialize() ;
}
