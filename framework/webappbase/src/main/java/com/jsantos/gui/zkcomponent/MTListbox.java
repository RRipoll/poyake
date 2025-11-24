package com.jsantos.gui.zkcomponent;

import java.io.IOException;

import org.zkoss.zhtml.Label;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTField;

public class MTListbox extends Listbox implements IMTComponent{

	private static final long serialVersionUID = 1L;
	String label;
	String field;
	MTField mtField;
	IMTConstraint constraint=new EmptyConstraint();
	private boolean isUpdated;	
	
	public MTListbox() {
		setSclass("form-control");
		addEventListener(Events.ON_FOCUS, new BootstrapFocusEventListener());
		addEventListener(Events.ON_BLUR, new BootstrapFocusEventListener());
		addEventListener(Events.ON_SELECT, new BootstrapFocusEventListener());
		//addEventListener(Events.ON_SELECT, this::validate);
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
		setMTField(MTBase.getMTField(field));
	}

	@Override
	protected void renderProperties(ContentRenderer renderer) throws IOException {
		super.renderProperties(renderer);
		renderer.render("label", getLabel());
		renderer.render("field", getField());
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
	public Object getValue() {
		return getSelectedItems();
	}
	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible,this);
	}
	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		if(null!=dRecord)	
		setValue(dRecord.get(mtField));
	}
	
	@Override
	public void setValue(Object value) {
		if(null==value)return;
		for (Listitem item : getItems()) {
			if(item.getValue().equals(value)) {
				setSelectedItem(item);
				try {
					Events.sendEvent(Events.ON_SELECT, this, null);
				}
				catch (Exception e) {;}
			}
					
}
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
