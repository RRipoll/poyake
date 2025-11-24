package com.jsantos.gui.zkcomponent;

import org.zkoss.zk.ui.WrongValueException;
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
import com.jsantos.orm.mt.MTField;

public class MTTextboxObjectDescription extends MTTextbox implements IMTComponent, IDetachedRecordAcceptor {

	IMTConstraint constraint = new EmptyConstraint();
	private static final long serialVersionUID = 1L;

	ListValues<IDetachedRecord> drs = new ListValues<IDetachedRecord>().setNotNull(true).setNotRepeted(true);

	@Override
	public void acceptDetachedRecord(ListValues<IDetachedRecord> drs, MTField externalField) {
		this.drs.addAllValues(drs);
		setValue(MultipleHelper.getDescription(drs, mtField, LocaleFactory.getProvider().getLocale()));
		Events.sendEvent(Events.ON_CHANGE, this, null);
		Events.sendEvent(CustomEvents.ON_ISUPDATED, this, null);
	}

	public MTTextboxObjectDescription() {
		super();
		this.setReadonly(true);
	}

	@Override
	public String getValue() throws WrongValueException {
		return super.getValue();
	}

	@Override
	public boolean isChildable() {
		return true;
	}

	public ListValues<IDetachedRecord> getDrs() {
		return drs;
	}

	public void setDrs(ListValues<IDetachedRecord> drs) {
		this.drs = drs;
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
}
