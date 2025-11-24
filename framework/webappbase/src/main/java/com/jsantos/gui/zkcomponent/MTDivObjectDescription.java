package com.jsantos.gui.zkcomponent;

import org.zkoss.zhtml.Div;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.jsantos.common.util.ListValues;
import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.objectselector.ObjectDescriptionItem;
import com.jsantos.gui.objectselector.popup.IDetachedRecordAcceptor;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;

/**
 * @author raul ripoll
 */
public class MTDivObjectDescription extends Div implements IMTComponent, IDetachedRecordAcceptor {
	private static final long serialVersionUID = 1L;
	protected String label;
	protected MTField mtField;
	protected String field;
	boolean readOnly = true;
	IMTConstraint constraint = new EmptyConstraint();
	BootstrapFocusEventListener bootstrapFocusEventListener = new BootstrapFocusEventListener();
	ListValues<IDetachedRecord> drs = new ListValues<IDetachedRecord>();
	private boolean isUpdated;

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;
		this.field = mtField.getFullyQualifiedName();
		setLabel(mtField.getLabel());
		addEventListener(Events.ON_FOCUS, bootstrapFocusEventListener);
		addEventListener(Events.ON_BLUR, bootstrapFocusEventListener);
		addEventListener(Events.ON_CHANGE, bootstrapFocusEventListener);
	}

	@Override
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;

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
	public void acceptDetachedRecord(ListValues<IDetachedRecord> newDrs, MTField mtField) {
		setDrs(newDrs);
		super.getChildren().clear();
		for (IDetachedRecord detachedRecord : drs) {
			ObjectDescriptionItem item = new ObjectDescriptionItem(detachedRecord, mtField, this, drs, readOnly);
			item.addEventListener(Events.ON_CHANGE, this::removeItem);
		}
		this.setSclass("card-columns");
		setStyle("min-height:30px;padding-top: 10px;display: block;");
		setUpdated(true);
	}

	public void removeItem(Event event) {
		acceptDetachedRecord(drs, mtField);
		event.stopPropagation();
		setUpdated(true);
	}

	@Override
	public void setReadonly(boolean readOnly) {
		this.readOnly = readOnly;
		if (!readOnly)
			this.setStyle("cursor:pointer");
		else
			this.setStyle("cursor:default");
	}

	public ListValues<IDetachedRecord> getDrs() {
		return drs;
	}

	public void setDrs(ListValues<IDetachedRecord> newDrs) {
		ListValues<IDetachedRecord> clone = new ListValues<IDetachedRecord>().addAllValues(newDrs);
		this.drs.clear();
		this.drs.addAll(clone);
	}

	@Override
	public Object getValue() {
		return drs;
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		setDrs((ListValues<IDetachedRecord>) dRecord.get(mtField));

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
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible, this);
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
			Events.sendEvent(CustomEvents.ON_ISUPDATED, this, drs);
	}

}
