package com.jsantos.gui.zkcomponent;

import org.zkoss.zhtml.Div;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.jsantos.commondata.util.DataFormatter;
import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;

public class MTFieldLabel extends Div implements IMTComponent{

	private static final long serialVersionUID = 1L;
	public String label;
	public String field;
	MTField mtField;
	IMTConstraint constraint=new EmptyConstraint();
	private boolean isUpdated;

	@Override
	public void setLabel(String label) {
		this.label = label;
		this.appendChild(new Text(label));
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public void setField(String field) {
		this.field = field;
		mtField = MTBase.getMTField(field);
		setLabel(Zklabel.getLabel(mtField.getFullyQualifiedName(),LocaleFactory.getProvider().getLocale()));
	}

	@Override
	public String getField() {
		return field;
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;
		this.field = mtField.getFullyQualifiedName();
	}

	@Override
	public void setReadonly(boolean readOnly) {
	}

	@Override
	public Object getValue() {
		return label;
	}
	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible,this);
	}
	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		setLabel(DataFormatter.formatAsString(mtField, dRecord.get(mtField)));
}
	

	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public IMTConstraint getConstraints() {
		return constraint;
	}
	@Override
	public void setConstraint(IMTConstraint constraint) {
		this.constraint = constraint;
	}

	@Override
	public Component initialize() {
		// TODO Auto-generated method stub
		return this;
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
