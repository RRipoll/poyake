package com.jsantos.custom.customfield;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.ComponentCtrl;
import org.zkoss.zul.Div;

import com.jsantos.common.constraint.ErrorsConstants;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.objectselector.popup.ObjectSelectorPopup;
import com.jsantos.gui.zkcomponent.BootstrapFocusEventListener;
import com.jsantos.gui.zkcomponent.MTTextboxObjectDescription;
import com.jsantos.gui.zkutil.MTAnnotation;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;
import com.jsantos.orm.pattern.autohistory.AutohistoryHelper;

public class PkFieldContainer extends Div implements IMTComponent {

	private static final long serialVersionUID = 6074213497280980062L;
	MTField mtField;
	MTTable mtTable;
	
	MTTextboxObjectDescription span;
	
	Component form;
	boolean readOnly = false;
	IMTConstraint constraint=new EmptyConstraint();
	private String field;
	private String label;
	private boolean isUpdated;

	@Override
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public Component initialize() {
		try {
			
			this.setSclass("form-group form-float");
			Div div2 = new Div();
			div2.setSclass("form-line");
			div2.setParent(this);

			span = new MTTextboxObjectDescription();
			span.setParent(div2);
			span.setMTField(mtField);
			span.setLabel(mtField.getLabel());
			span.addEventListener(Events.ON_CLICK, this::searchFolder);
			span.addEventListener(Events.ON_CHANGE, this::onChange);
			span.addEventListener(CustomEvents.ON_ISUPDATED, this::setUpdated);
			span.setAttribute("nonReadable", "true");
			
			MTAnnotation.setMTField((ComponentCtrl) span, mtField);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new WrongValueException(this, ErrorsConstants.FILE_ERROR);
		}
		return this;
	}

	void searchFolder(Event evt) {
		if (readOnly)
			return;
		new ObjectSelectorPopup(mtField,mtTable, span).doModal();
	}

	void onChange(Event evt) {
		validate(evt);
	}
		

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {

		MTField field=mtField.getForeignKey().getPrimaryKey();
		if (null != dRecord && null != ((IDetachedRecord) dRecord).get(mtField)) {
			span.acceptDetachedRecord(new ListValues<IDetachedRecord>()
				.addValue(new DetachedRecord(mtTable, 
					new MapValues<Object>().add(field.getName(), dRecord.get(mtField))
					)),field);
		}
		validate(null);
	}

	@Override
	public Object getValue() {
		Object retValue=null;
		if (null != span.getDrs() && !span.getDrs().isEmpty()) {
			IDetachedRecord dr=span.getDrs().get(0);
			if(dr.getTable().getPatterns().contains("AutoHistory")) {
				MTField field=dr.getTable().getMainFk();
				retValue= span.getDrs().get(0).get(field);
			}
			retValue= dr.get(dr.getTable().getPrimaryKey());
		}
		return retValue;
	}

	@Override
	public MTDataType forModelType() {
		return null;
	}

	public void setMtField(MTField mtField) {
		this.mtField = mtField;
		if(null==mtTable)mtTable=mtField.getForeignKey().getRealFKTOTable();
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;
	}

	@Override
	public void setReadonly(boolean readOnly) {
		this.readOnly = readOnly;
		span.setReadonly(readOnly);
	}

	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible,this);
	}
	
	public void setCustomComponent(IMTComponent customComponent) {
	}

	
	public IMTComponent getCustomComponent() {
		return span;
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
	public void setLabel(String label) {
		this.label=label;
		span.setLabel(label);
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setField(String field) {
		this.field=field;
		setMTField(MTBase.getMTField(field));
		initialize();
	}

	@Override
	public String getField() {
		return field;
	}

	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isUpdated() {
		return isUpdated;
	}

	@Override
	public void setUpdated(boolean isUpdated) {
		this.isUpdated=isUpdated;
		if(isUpdated)
			Events.sendEvent(CustomEvents.ON_ISUPDATED, this, span.getValue());
	}
	
	public void setUpdated(Event isUpdated) {
		setUpdated(true);
	}
}
