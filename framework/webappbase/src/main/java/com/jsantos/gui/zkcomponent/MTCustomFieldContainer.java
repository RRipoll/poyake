package com.jsantos.gui.zkcomponent;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zhtml.Div;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

import com.jsantos.common.model.EditMode;
import com.jsantos.custom.customfield.CustomFieldContainerProvider;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;

public class MTCustomFieldContainer extends Div implements IMTComponent {
	private static final long serialVersionUID = 1L;
	String label;
	String field;
	MTField mtField;
	IMTComponent customContainer;
	EditMode mode = EditMode.INSERT;
	private boolean isUpdated;

	public MTCustomFieldContainer() {
		this.setSclass("form-line");
	}

	@Override
	public void setConstraint(IMTConstraint constr) {
		customContainer.setConstraint(constr);
	}

	@Override
	public IMTConstraint getConstraints() {
		return customContainer.getConstraints();
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;

		if (mode.equals(null)) {
			setSclass("form-line");
			this.customContainer = new MTCustomCellBuilder();
			customContainer.setMTField(mtField);
		} else {

			this.customContainer = CustomFieldContainerProvider.getCustomFieldContainer(mtField);
		}
		customContainer.initialize().setParent(this);
		customContainer.addEventListener(CustomEvents.ON_ISUPDATED, this::setUpdated);
		customContainer.addEventListener(CustomEvents.ON_CUSTOMFIELD_UPDATE, this::customFieldUpdate);
		if (StringUtils.isEmpty(label))
			label = Zklabel.getLabel(mtField.getFullyQualifiedName(), LocaleFactory.getProvider().getLocale());
		setLabel(label);
	}

	@Override
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public String getField() {
		return field;
	}

	@Override
	public void setField(String field) {
		this.field = field;
		setMTField(MTBase.getMTField(field));
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		customContainer.setDetachedRecord(dRecord);

	}

	@Override
	public void setValue(Object value) {
		setDetachedRecord((IDetachedRecord) value);

	}

	@Override
	public Component initialize() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCustomComponent(IMTComponent customComponent) {
		this.customContainer = customComponent;

	}

	public IMTComponent getCustomComponent() {
		return customContainer;
	}

	@Override
	public void setLabel(String label) {
		if (null != getCustomComponent())
			getCustomComponent().setLabel(label);
	}

	@Override
	public String getLabel() {
		if (null == getCustomComponent())
			return null;
		return getCustomComponent().getLabel();

	}

	@Override
	public void setReadonly(boolean readOnly) {
		if (null != getCustomComponent())
			getCustomComponent().setReadonly(readOnly);
	}

	@Override
	public Object getValue() {
		if (null == getCustomComponent())
			return null;
		return getCustomComponent().getValue();
	}

	public EditMode getMode() {
		return mode;
	}

	public void setMode(EditMode mode) {
		this.mode = mode;
	}

	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible, this);
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
	
	public void customFieldUpdate(Event event) {
		
		Events.sendEvent(
				new Event(CustomEvents.ON_CUSTOMFIELD_UPDATE, this,	event.getData())
						);
		
	}

}
