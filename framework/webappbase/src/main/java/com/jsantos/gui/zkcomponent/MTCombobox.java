package com.jsantos.gui.zkcomponent;

import java.io.IOException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;

public class MTCombobox extends Combobox implements IMTComponent{
	private static final long serialVersionUID = 1L;
	MTField mtField;
	String label;
	String field;
	IMTConstraint constraint=new EmptyConstraint();
	private boolean isUpdated;
	
	public MTCombobox() {
		setSclass("form-control");
		addEventListener(Events.ON_FOCUS, new BootstrapFocusEventListener());
		addEventListener(Events.ON_BLUR, new BootstrapFocusEventListener());
		addEventListener(Events.ON_CHANGE, new BootstrapFocusEventListener());
	}
	
	@Override
	public MTField getMTField() {
		return mtField;
	}
	
	@Override
	public void setSelectedIndex(int jsel) {
		super.setSelectedIndex(jsel);
		Events.sendEvent(Events.ON_CHANGE, this, null);
	}

	@Override
	public void setSelectedItem(Comboitem item) {
		super.setSelectedItem(item);
		Events.sendEvent(Events.ON_CHANGE, this, null);
	}
	@Override
	public String getLabel() {
		return label;
	}
	@Override
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String getField() {
		return field;
	}
	@Override
	public void setField(String field) {
		this.field = field;
	}

	@Override
	protected void renderProperties(ContentRenderer renderer) throws IOException {
		super.renderProperties(renderer);
		renderer.render("label", getLabel());
		renderer.render("field", getField());
	}

	@Override
	public void setMTField(MTField mtField) {
		if (null != mtField) {
			this.field = mtField.getName();
			this.mtField = mtField;
		}
	}
	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible,this);
	}
	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		// TODO Auto-generated method stub
		setPk((Integer) dRecord.get(mtField));
	}

	public void setPk(Integer pk){
		setSelectedIndex(-1);
		if (null != pk){
			for (Comboitem item:getItems()){
				if (item.getValue() != null && pk.intValue() == ((Integer) item.getValue()).intValue()) {
					setSelectedItem(item);
					item.setValue(pk);
				}
			}
		}
	}
	
	public  void setBlankItem(MTField field) {
		if(field.isNullable()){
			Comboitem item= new Comboitem();
			insertBefore(item, getItemAtIndex(0));
			if(null==getSelectedItem()){
				setSelectedItem(item);
			}
			invalidate();
		}
	}

	

	@Override
	public void setValue(Object value) {
		setPk( (Integer) value);// TODO Auto-generated method stub
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
