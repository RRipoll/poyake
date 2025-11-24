package com.jsantos.gui.zkcomponent;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Radio;

import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;

public class MTRadio extends Radio implements IMTComponent{
	
	private static final long serialVersionUID = 1L;
	String field;
	String value;
	String shortcode;
	MTField mtField;
	IMTConstraint constraint=new EmptyConstraint();
	private boolean isUpdated;

	@Override
	public void setField(String field) {
		this.field = field;
		mtField = MTBase.getMTField(field);
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
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(Object value) {
		this.value = (String)value;
	}

	public Integer getIntValue() {
		if (StringUtils.isNotBlank(value) && NumberUtils.isNumber(value))
			return Integer.parseInt(value);
		else if (null != mtField && StringUtils.isNotBlank(shortcode) && null != mtField.getForeignKey() && null != mtField.getForeignKey().getEnumeration()) {
			return mtField.getForeignKey().getEnumeration().getShortCodes().get(shortcode);
		}
		return null;
	}

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortCode) {
		this.shortcode = shortCode;
		
		// now we lookup the description for that shortcode and use it as label if no label is set
		if (null != mtField && StringUtils.isNotBlank(shortCode) && null != mtField.getForeignKey() && null != mtField.getForeignKey().getEnumeration()) {
			if (StringUtils.isBlank(getLabel())) {
				Integer intValue = mtField.getForeignKey().getEnumeration().getShortCodes().get(shortCode);
				if (null != intValue) {
					String description = mtField.getForeignKey().getEnumeration().getValue(intValue);
					if (StringUtils.isNotBlank(description))
						setLabel(description);
				}
			}
		}
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;
		this.field = mtField.getFullyQualifiedName();
		
	}

	@Override
	public void setReadonly(boolean readOnly) {
		this.setDisabled(readOnly);
		
	}
	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible,this);
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		    setValue(dRecord.get(mtField));
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
