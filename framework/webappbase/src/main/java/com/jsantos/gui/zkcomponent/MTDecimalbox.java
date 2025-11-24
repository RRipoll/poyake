package com.jsantos.gui.zkcomponent;

import java.math.BigDecimal;

import org.zkoss.zhtml.Label;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Decimalbox;

import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;

public class MTDecimalbox extends Decimalbox implements IMTComponent {

	private static final long serialVersionUID = 1L;
	String label;
	String field;
	MTField mtField;
	IMTConstraint constraint = new EmptyConstraint();
	private boolean isUpdated;

	public MTDecimalbox() {
		setZclass("form-control");
		addEventListener(Events.ON_FOCUS, new BootstrapFocusEventListener());
		addEventListener(Events.ON_BLUR, new BootstrapFocusEventListener());
		addEventListener(Events.ON_CHANGE, new BootstrapFocusEventListener());
	}

	@Override
	public void setValue(Object value) throws WrongValueException {
		super.setValue((BigDecimal) value);
		Events.sendEvent(Events.ON_CHANGE, this, null);
	}

	@Override
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
		Label labelTag = new Label();
		labelTag.setSclass("form-label");
		labelTag.setDynamicProperty("onClick", "$(this).parent().find('input').focus()");
		labelTag.setDynamicProperty("for", getUuid());
		labelTag.setParent(getParent());
		Text text = new Text(label);
		text.setParent(labelTag);
	}

	@Override
	public String getField() {
		return field;
	}

	@Override
	public void setField(String field) {
		this.field = field;
		MTBase.getMTField(field);
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;
		this.field = mtField.getFullyQualifiedName();
	}

	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible, this);
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		setValue((BigDecimal) dRecord.get(mtField));
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
