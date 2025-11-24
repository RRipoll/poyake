package com.jsantos.custom.customfield;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;

import com.jsantos.common.constraint.ErrorsConstants;
import com.jsantos.custom.cell.general.JsonBuilder;
import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.zkcomponent.BootstrapFocusEventListener;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class JsonContainer extends Div implements IMTComponent {

	private static final long serialVersionUID = 943847624190836961L;

	String field;

	IMTConstraint constraint = new EmptyConstraint();

	MTField mtField;

	JsonBuilder customComponent;

	private boolean isUpdated;

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;

	}

	@Override
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.JSON;
	}

	@Override
	public Component initialize() {

		try {

			this.setSclass("form-group form-float");
			Div div2 = new Div();
			div2.setSclass("form-line");
			div2.setParent(this);
			customComponent = new JsonBuilder();
            customComponent.addEventListener(CustomEvents.ON_ISUPDATED, this::setUpdated);
			Component comp = customComponent.buildGridComponent(mtField, null, null, LocaleFactory.getProvider().getLocale());
			comp.setParent(div2);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new WrongValueException(this, ErrorsConstants.FILE_ERROR);
		}
		return this;

	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public void setLabel(String label) {

	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		customComponent.setDetachedRecord(dRecord);
		setValue(dRecord.get(mtField));

	}

	@Override
	public void setValue(Object value) {
		customComponent.setValue(value);
	}

	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible,this);
	}

	@Override
	public void setReadonly(boolean readOnly) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setConstraint(IMTConstraint constraint) {
		this.constraint = constraint;
	}

	@Override
	public IMTConstraint getConstraints() {
		return constraint;
	}

	@Override
	public Object getValue() {
		return customComponent.getValue();
	}

	@Override
	public void setField(String field) {
		this.field=field;
		setMTField(MTBase.getMTField(field));
		initialize();
	}

	@Override
	public String getField() {
		return field;
	}
	
	public Component getHeaderDiv() {
		
		return customComponent.getHeaderDiv();
	}

	
	@Override
	public boolean isUpdated() {
		return isUpdated;
	}

	@Override
	public void setUpdated(boolean isUpdated) {
		this.isUpdated=isUpdated;
		if(isUpdated)
			Events.sendEvent(CustomEvents.ON_ISUPDATED, this, getValue());
	}
	
	public void setUpdated(Event isUpdated) {
		setUpdated(true);
	}
}
