package com.jsantos.custom.customfield;

import java.util.Map;

import org.zkoss.zhtml.Label;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.ComponentCtrl;
import org.zkoss.zul.Div;

import com.jsantos.common.constraint.ErrorsConstants;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.datagrid4.GridSelectorType;
import com.jsantos.gui.objectselector.popup.ObjectSelectorPopup;
import com.jsantos.gui.zkcomponent.BootstrapFocusEventListener;
import com.jsantos.gui.zkcomponent.MTMultipleObjectDescription;
import com.jsantos.gui.zkutil.MTAnnotation;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;
/**
 * @author raul ripoll
 */
public class MTMultiObjectContainer extends Div implements IMTComponent{
	
	private static final long serialVersionUID = -1637965229371929099L;

	MTField mtField;
	
	MTMultipleObjectDescription span;
	
	Component form;
	String ZulUri;
	boolean readOnly=false;
	IMTConstraint constraint;
	private MapValues<Object> initialParameters;
	MTTable linkObjectTable;
	IDetachedRecord dRecord;
	boolean isUpdated=false;
	private String field;

	private String label;
	
	@Override
	public MTField getMTField() {
		return mtField;
	}

	@Override
	public Component initialize(){
		try {
			
			this.setSclass("form-group form-float");
			this.setStyle("cursor: text");
			Div div2 = new Div();
			div2.setSclass("form-line");
			div2.setParent(this);
			
			span = new MTMultipleObjectDescription();
			span.setMTField(mtField);
			span.setParent(div2);
			span.setLabel(mtField.getLabel());

			this.addEventListener(Events.ON_CLICK, this::searchFolder);
			
			span.setAttribute("nonReadable", "true");
			span.setReadonly(readOnly);

			MTAnnotation.setMTField((ComponentCtrl)span, mtField);
			Label label = new Label();
			label.setParent(div2);
			label.setSclass("form-label");
			label.setDynamicProperty("onClick", "$(this).parent().find('input').focus()");
			label.setDynamicProperty("for", span.getUuid());
			//label.addEventListener(Events.ON_CLICK, this::searchFolder);
			new Text(mtField.getName()).setParent(label);
			//span.setHflex("1");
		}
		catch(Throwable e) {
			e.printStackTrace();
			throw new WrongValueException(this, ErrorsConstants.FILE_ERROR);
			}
		return this;
	}
	
	void searchFolder(Event evt) {
		if (readOnly)
			return;
		MTTable objectTable=MultipleHelper.getLinkOut(mtField).getForeignKey();
		if(objectTable.isPkTable())
			objectTable=objectTable.getRealFKTOTable();
		ObjectSelectorPopup popup=new ObjectSelectorPopup(mtField,objectTable, span);
		   popup.isUpdated();
		popup.setSelector(GridSelectorType.CHECKBOX);
		popup.doModal();
		setUpdated(popup.isUpdated());
		
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		this.dRecord=dRecord;
		if(null!=dRecord ) {
			ListValues<IDetachedRecord> drs=(ListValues<IDetachedRecord>)dRecord.get(mtField);
			span.acceptDetachedRecord(drs,mtField);
			}
	}
    
	@Override
	public Object getValue()  {
		return span.getDrs();
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.MULTIPLEOBJECT;
	}

	public void setMtField(MTField mtField) {
		this.mtField = mtField;
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField=mtField;
		linkObjectTable = MultipleHelper.getLinkTable(mtField);
	}

    Map<Integer, String> getDataVector(){
		return linkObjectTable.getEnumeration().getHashmap();
	};

	@Override
	public void setReadonly(boolean readOnly) {
		this.readOnly=readOnly;
		span.setReadonly(readOnly);
		
	}

	@Override
	public void setValue(Object value) {
		span.acceptDetachedRecord((ListValues<IDetachedRecord>) value,mtField);
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
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible,this);
	}

	public boolean isUpdated() {
		return isUpdated;
	}
	
	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
		Events.sendEvent(Events.ON_CHANGE, this,getValue());
	}
}
