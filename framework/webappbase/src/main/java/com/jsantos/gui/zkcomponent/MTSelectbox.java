package com.jsantos.gui.zkcomponent;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.zkoss.zhtml.Label;
import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Selectbox;

import com.jsantos.common.i18n.MTLabels;
import com.jsantos.common.util.ListValues;
import com.jsantos.custom.constraints.EmptyConstraint;
import com.jsantos.custom.customfield.IMTComponent;
import com.jsantos.factory.locale.LocaleFactory;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.constraints.IMTConstraint;
import com.jsantos.gui.zkutil.Zklabel;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTBase;
import com.jsantos.orm.mt.MTEnumeration;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class MTSelectbox extends Selectbox implements  IMTComponent{
	
	private static final long serialVersionUID = 1L;
	String label;
	String field;
	MTField mtField;
	ListModelList<ModelListItem> listModel = new ListModelList<>();
	public ListModelList<ModelListItem> getListModel() {
		return listModel;
	}

	public void setListModel(ListModelList<ModelListItem> listModel) {
		this.listModel = listModel;
	}

	IMTConstraint constraint=new EmptyConstraint();
	private boolean isUpdated;

	public MTSelectbox() {
		setZclass("form-control");
		addEventListener(Events.ON_FOCUS, new BootstrapFocusEventListener());
		addEventListener(Events.ON_BLUR, new BootstrapFocusEventListener());
		addEventListener(Events.ON_SELECT, new BootstrapFocusEventListener());
		//addEventListener(Events.ON_SELECT, this::validate);
		
		setModel(listModel);
		listModel.add(new ModelListItem(null, ""));
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
	public MTField getMTField() {
		return mtField;
	}
	
	public void setEnumeration(MTEnumeration enu) {
		
		for (Integer key: enu.getKeys()) {
			listModel.add(new ModelListItem(key, MTLabels.getLabel(enu, key,LocaleFactory.getProvider().getLocale())));
		}
	}
	
	public void add(Integer pk, String label,boolean selected) {
		for (ModelListItem modelListItem : listModel) {
			if(modelListItem.pk==pk)return;
		}
		ModelListItem ml=new ModelListItem(pk, label);
		listModel.add(ml);
		if(selected)listModel.addToSelection(ml);
	}
	
	public Integer getPk() {
		if (-1==getSelectedIndex()) return null;
		return listModel.get(getSelectedIndex()).pk;
	}
	
	public void setPk(Integer pk) {
		if(null==pk)return;
		for (ModelListItem item:listModel) {
			if(null==item.pk) {
				if(null==pk) {setSelectedIndex(listModel.indexOf(item));
				listModel.setMultiple(false);
				listModel.setSelection(Arrays.asList(item));
				break;
				}
			}else if (item.pk.intValue() == pk) {
				setSelectedIndex(listModel.indexOf(item));
				listModel.setMultiple(false);
				listModel.setSelection(Arrays.asList(item));
				break;
			}
		}
		try {
			Events.sendEvent(Events.ON_SELECT, this, null);
		}
		catch (Exception e) {;}
	}
	
	public void setPkNoPropagated(Integer pk) {
		for (ModelListItem item:listModel) {
			if (item.pk == pk) {
				setSelectedIndex(listModel.indexOf(item));
				listModel.setMultiple(false);
				listModel.setSelection(Arrays.asList(item));
			}
		}
		try {
			Events.sendEvent(Events.ON_SELECT, this, null);
		}catch (Exception e) {;}
	}
	
	public class ModelListItem {
		Integer pk;
		String label;
		
		public ModelListItem(Integer pk, String label) {
			this.pk=pk;
			this.label=label;
		}
		
		public String toString() {
			return label;
		}
	}
	

	@Override
	public void setMTField(MTField mtField) {
		this.mtField = mtField;
		this.field = mtField.getFullyQualifiedName();
		if (StringUtils.isEmpty(label))
			setLabel(Zklabel.getLabel(mtField.getFullyQualifiedName(),LocaleFactory.getProvider().getLocale()));
		buildObjectList(mtField.getForeignKey(), new ListValues<Object>());
	}

	@Override
	public void setReadonly(boolean readOnly) {
		this.setDisabled(readOnly);
	}
	
	public void buildObjectList( MTTable mtTable,ListValues<Object>initialValues){
		for (Integer key:mtTable.getEnumeration().getKeys()) {
			add(key, MTLabels.getLabel(mtTable.getEnumeration(), key,LocaleFactory.getProvider().getLocale()),initialValues.contains(key));
		}
	}

	@Override
	public void setDetachedRecord(IDetachedRecord dRecord) {
		setPk(dRecord.getInt(mtField));
	}

	@Override
	public void setValue(Object value) {
		setPk((Integer)value);
	}

	@Override
	public Object getValue() {
		return getPk();
	}
	
	@Override
	public IMTConstraint getConstraints() {
		return constraint;
	}

	@Override
	public void setConstraint(IMTConstraint constraint) {
		this.constraint=constraint;
	}

	@Override
	public Component initialize() {
		
		return this;
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
			Events.sendEvent(CustomEvents.ON_ISUPDATED, this, getValue());
	}
	
	public void setUpdated(Event isUpdated) {
		setUpdated(true);
	}
}
