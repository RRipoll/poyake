package com.jsantos.custom.customfield;

import org.zkforge.ckez.CKeditor;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;

import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.form.FormZulBuilder;
import com.jsantos.gui.zkcomponent.BootstrapFocusEventListener;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
/**
 * @author raul ripoll
 */
public class HtmlFieldContainer  extends Div implements IMTComponent{

	String field;
	String label;
	MTField mTField;
	CKeditor editor;
	IMTConstraint constraints;
	Label labelTag;
	private boolean isUpdated;
	
	@Override
	public void setLabel(String label) {
		this.label=label;
		labelTag.setValue(label);
		
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mTField=mtField;
		
	}

	@Override
	public MTField getMTField() {
		
		return mTField;
	}

	@Override
	public void setField(String field) {
		this.field=field;
		
	}

	@Override
	public String getField() {
		return field;
	}

	@Override
	public void setReadonly(boolean readOnly) {
		
		
	}

	@Override
	public Object getValue() {
		
		return editor.getValue();
	}

	@Override
	public void setValue(Object value) {
		editor.setValue((String) value);
		
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		editor.setValue(dRecord.getString(mTField));
		
	}
	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible,this);
	}
	@Override
	public IMTConstraint getConstraints() {
		
		return constraints;
	}

	@Override
	public void setConstraint(IMTConstraint constraint) {
		this.constraints=constraint;
		
	}

	@Override
	public Component initialize() {
          String template="~./common/zul/customcomponents/html_component.zul";
          FormZulBuilder builder= new FormZulBuilder();
          builder.setZulURI(template);
		  Component form=builder.buildForm(this);
		  editor=(CKeditor) form.getFellow("HTML_EDITOR");
		  editor.setCustomConfigurationsPath("/widgets/input/wysiwyg_editor/config.js?rev=2206");
		  labelTag= (Label) form.getFellow("HTML_LABEL");
		return this;
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.HTML;
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
