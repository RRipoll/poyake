package com.jsantos.gui.zkcomponent;

import org.zkoss.zhtml.Span;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.jsantos.common.util.ListValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.objectselector.popup.IDetachedRecordAcceptor;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;

public class MTSpanObjectDescription extends Span implements IMTComponent, IDetachedRecordAcceptor {
	private static final long serialVersionUID = 1L;
	protected String label;
	protected MTField mtField;
	protected String field;
	ListValues<IDetachedRecord> drs;
	IMTConstraint constraint = new EmptyConstraint();
	private boolean isUpdated;

	public MTField getMtField() {
		return mtField;
	}

	public void setMtField(MTField mtField) {
		this.mtField = mtField;
		this.field = mtField.getFullyQualifiedName();
		setLabel(mtField.getLabel());
	}

	@Override
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
		getChildren().clear();
		new Text(label).setParent(this);

	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setField(String field) {
		this.field = field;
		mtField = MTBase.getMTField(field);
	}

	@Override
	public String getField() {
		return field;
	}

	@Override
	public void acceptDetachedRecord(ListValues<IDetachedRecord> drs, MTField mtField) {
		this.drs = drs;

		setLabel(MultipleHelper.getDescription(drs, mtField, LocaleFactory.getProvider().getLocale()));
		Events.sendEvent(Events.ON_CHANGE, this, null);
		setUpdated(true);
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;
		this.field = mtField.getFullyQualifiedName();
	}

	@Override
	public void setReadonly(boolean readOnly) {
		if (!readOnly)
			this.setStyle("cursor:pointer");
		else
			this.setStyle("cursor:default");

	}

	public ListValues<IDetachedRecord> getDrs() {
		return drs;
	}

	public void setDrs(ListValues<IDetachedRecord> drs) {
		this.drs = drs;
	}

	@Override
	public Object getValue() {
		return drs;
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		setDrs((ListValues<IDetachedRecord>) dRecord.get(mtField));
		Events.sendEvent(Events.ON_CHANGE, this, null);
	}

	@Override
	public void setValue(Object value) {
		setDrs((ListValues<IDetachedRecord>) value);
		Events.sendEvent(Events.ON_CHANGE, this, null);
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
		this.isUpdated = isUpdated;
		if (isUpdated)
			Events.sendEvent(CustomEvents.ON_ISUPDATED, this, getValue());
	}

	public void setUpdated(Event isUpdated) {
		setUpdated(true);
	}
}
