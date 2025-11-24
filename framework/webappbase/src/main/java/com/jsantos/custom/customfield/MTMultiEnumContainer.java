package com.jsantos.custom.customfield;

import java.util.Vector;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.ComponentCtrl;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Popup;

import com.jsantos.common.constraint.ErrorsConstants;
import com.jsantos.common.i18n.MTLabels;
import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.factory.DTOFactory;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.zkcomponent.BootstrapFocusEventListener;
import com.jsantos.gui.zkcomponent.MTTextboxObjectDescription;
import com.jsantos.gui.zkutil.MTAnnotation;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.DetachedRecord;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class MTMultiEnumContainer extends Div implements IMTComponent {

	private static final long serialVersionUID = 2045272114957417186L;

	MTField mtField;

	MTTextboxObjectDescription span;

	Component form;
	String ZulUri;
	boolean readOnly = false;
	IMTConstraint constr;
	private MapValues<Object> initialParameters;
	private Popup popup;
	private Listbox listbox;
	public Vector<Checkbox> vectorCheckBox = new Vector<Checkbox>();
	MTTable linkObjectTable;
	IDetachedRecord dRecord;

	private String label;

	private String field;

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
			span.setMTField(mtField);
			span.setParent(div2);
			span.setLabel(mtField.getLabel());
			span.addEventListener(CustomEvents.ON_ISUPDATED, this::setUpdated);
			span.addEventListener(Events.ON_CLICK, this::searchFolder);
			span.setAttribute("nonReadable", "true");
			span.setMultiline(true);
			span.setReadonly(readOnly);

			MTAnnotation.setMTField((ComponentCtrl) span, mtField);
			listbox = new Listbox();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new WrongValueException(this, ErrorsConstants.FILE_ERROR);
		}
		return this;
	}

	void searchFolder(Event evt) {
		if (readOnly)
			return;
		if (null == popup) {
			popup = new Popup();
			popup.setStyle("overflow:hiden");
			popup.setHflex("min");
			popup.setVflex("min");
			popup.setParent(span);
			listbox.setHflex("min");
			listbox.setVflex("min");
			listbox.setParent(popup);
		}
		popup.open(span);
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		this.dRecord = (IDetachedRecord) dRecord;
		if (null != dRecord) {
			ListValues<IDetachedRecord> drs = new ListValues<IDetachedRecord>()
					.addAllValues((ListValues<IDetachedRecord>) ((IDetachedRecord) dRecord).get(mtField));
			layout(drs);
			span.acceptDetachedRecord(drs, mtField);
		}
	}

	@Override
	public Object getValue() {
		ListValues<IDetachedRecord> retvalues = new ListValues<IDetachedRecord>();

		if (null != mtField.getMultiRefTo()) {
			MTField linkout = MultipleHelper.getLinkOut(mtField);
			MTField linkin = MultipleHelper.getLinkIn(mtField);

			for (Checkbox checkbox : vectorCheckBox) {
				if (checkbox.isChecked()) {
					DetachedRecord dt = DTOFactory.get(mtField.getMultiRefTo());
					dt.set(linkout, checkbox.getValue());
					dt.set(linkin, dRecord.getPk());
					retvalues.add(dt);
				}
			}
		} else {
			for (Checkbox checkbox : vectorCheckBox) {
				if (checkbox.isChecked()) {
					DetachedRecord dt = DTOFactory.get(mtField.getForeignKey());
					dt.set(mtField.getForeignKey().getPrimaryKey(), checkbox.getValue());
					retvalues.add(dt);
				}
			}
		}
		return retvalues;
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.MULTIPLEENUM;
	}

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;
		linkObjectTable = MultipleHelper.getLinkTable(mtField);
	}

	public void layout(ListValues<IDetachedRecord> drs) {
		listbox.getChildren().clear();
		MTEnumeration enu = linkObjectTable.getEnumeration();
		for (Integer key : enu.getKeys()) {

			String description = MTLabels.getLabel(enu, key, LocaleFactory.getProvider().getLocale());

			Listitem listitem = new Listitem();
			listitem.setParent(listbox);
			Listcell listcell = new Listcell();
			listcell.setParent(listitem);
			Checkbox checkbox = new Checkbox(description);
			checkbox.setParent(listcell);

			checkbox.setAttribute("code", description);
			checkbox.setAttribute("owner", this);
			checkbox.setValue(key);
			checkbox.addEventListener("onCheck", this::check);

			vectorCheckBox.add(checkbox);
			org.zkoss.zul.Label label = new org.zkoss.zul.Label();
			label.setParent(listcell);

			for (IDetachedRecord element : drs) {
				MTField field = linkObjectTable.getPrimaryKey().getRealField();
				Integer value = null;
				for (MTField efield : element.getFields()) {
					if (efield.getRealField().getName().equals(field.getRealField().getName())) {
						value = element.getInt(efield);
					}
				}
				if (null != value && value.intValue() == key)
					checkbox.setChecked(true);
			}
		}
	}

	public void check(Event event) {
		Checkbox chk = (Checkbox) event.getTarget();
		String code = chk.getAttribute("code").toString();
		String valueShown = "";

		for (Checkbox item : vectorCheckBox) {
			if (item.isChecked()) {
				if (valueShown.length() > 0)
					valueShown += ",";
				valueShown += item.getAttribute("code");
			}
		}
		span.setValue(valueShown);
		Events.postEvent(new Event(Events.ON_CHANGE, span, vectorCheckBox));
	}

	@Override
	public void setReadonly(boolean readOnly) {
		this.readOnly = readOnly;
		span.setReadonly(readOnly);
	}
/*
	@Override
	public void setDefaultValue() {
		if (null != mtField.getDefaultValue())
			setDetachedRecord(new DetachedRecord(MultipleHelper.getLinkOut(mtField).getForeignKey(),
					Integer.parseInt(mtField.getDefaultValue())));
	}
*/
	public void setCustomComponent(IMTComponent customComponent) {
		span = (MTTextboxObjectDescription) customComponent;

	}

	public IMTComponent getCustomComponent() {
		return span;
	}

	@Override
	public IMTConstraint getConstraints() {
		return constr;
	}

	@Override
	public void setConstraint(IMTConstraint constraint) {
		this.constr = constraint;
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
	public void setLabel(String label) {
		this.label=label;
		
	}

	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean setVisible(boolean visible) {
		return BootstrapFocusEventListener.setVisible(visible,this);
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