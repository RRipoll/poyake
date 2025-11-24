package com.jsantos.gui.zkcomponent;

import org.zkoss.zhtml.Label;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;

import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.datagrid4.CellEntity;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;

public class MTCustomCellBuilder extends Div implements IMTComponent {

	String field;
	MTField mtField;
	Component component;
	String label;
	Label labelTag;
	private boolean isUpdated;

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
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;

	}

	@Override
	public void setLabel(String label) {
		this.label = label;
		if (null != label) {
			setZclass("form-control");
			if (null == labelTag) {
				labelTag = new Label();
				labelTag.setSclass("form-label");
				labelTag.setDynamicProperty("onClick", "$(this).parent().find('input').focus()");
				labelTag.setDynamicProperty("for", getUuid());
				labelTag.setParent(getParent());
			}
			labelTag.getChildren().clear();
			Text text = new Text(label);
			text.setParent(labelTag);
		}
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setReadonly(boolean readOnly) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(Object value) {
		if (!getValue().equals(value)) {
		}

	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		this.component = CellEntity.getCellBuilder(mtField, dRecord);
		component.setParent(this);
	}

	@Override
	public IMTConstraint getConstraints() {
		return null;
	}

	@Override
	public void setConstraint(IMTConstraint constraint) {
	}

	@Override
	public Component initialize() {

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
