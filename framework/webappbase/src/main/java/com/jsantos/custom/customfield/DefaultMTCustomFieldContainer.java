package com.jsantos.custom.customfield;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.ComponentCtrl;
import org.zkoss.zul.Div;

import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.form.ZulFieldTagEditorBuilder;
import com.jsantos.gui.zkcomponent.BootstrapFocusEventListener;
import com.jsantos.gui.zkutil.MTAnnotation;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.AttributeConstants;

public class DefaultMTCustomFieldContainer extends Div implements IMTComponent {

	private static final long serialVersionUID = 1L;

	MTField mtField;
	Div componentParent;
	IMTComponent customComponent;
	IDetachedRecord dRecord;

	private boolean isUpdated;

	public DefaultMTCustomFieldContainer() {
		super();
		this.setSclass("form-group form-float");
		componentParent = new Div();
		componentParent.setSclass("form-line");
		componentParent.setParent(this);

	}

	@Override
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public Component initialize() {
		setCustomComponent(ZulFieldTagEditorBuilder.buildEditorForField(mtField));
		getCustomComponent().initialize();
		return this;
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		this.dRecord = dRecord;
		customComponent.setDetachedRecord(dRecord);
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;
	}

	public IMTComponent getCustomComponent() {
		return customComponent;
	}

	public void setCustomComponent(IMTComponent customCom) {
		this.customComponent = customCom;
		customComponent.setAttribute("nonReadable", "true");
		customComponent.setAttribute(AttributeConstants.FIELD, mtField.getName());
		customComponent.setParent(componentParent);
		MTAnnotation.setMTField((ComponentCtrl) customComponent, mtField);
		customComponent.setMTField(mtField);
		customComponent.addEventListener(CustomEvents.ON_ISUPDATED, this::setUpdated);
	}

	public Object getValue() {
		return getCustomComponent().getValue();
	}

	public void setReadonly(boolean readOnly) {
		getCustomComponent().setReadonly(readOnly);
	}

	public String getLabel() {
		return getCustomComponent().getLabel();

	}

	public void setValue(Object value) {
		getCustomComponent().setDetachedRecord((IDetachedRecord) value);
	}

	public void setLabel(String label) {
		getCustomComponent().setLabel(label);
	}

	public IMTConstraint getConstraints() {
		return getCustomComponent().getConstraints();
	}

	public void setConstraint(IMTConstraint constraint) {
		getCustomComponent().setConstraint(constraint);
	}

	public void setField(String field) {
		getCustomComponent().setField(field);
	}

	public String getField() {
		return getCustomComponent().getField();
	}

	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible, customComponent);
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
