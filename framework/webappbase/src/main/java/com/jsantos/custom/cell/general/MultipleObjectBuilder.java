package com.jsantos.custom.cell.general;

import java.util.Date;
import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Div;
import org.zkoss.zul.Label;

import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.custom.cell.IGridCellBuilder;
import com.jsantos.gui.CustomEvents;
import com.jsantos.gui.filteredgrid.JsonEditor;
import com.jsantos.gui.form.CrudScreen;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class MultipleObjectBuilder   implements IGridCellBuilder{

	Object value;
	IDetachedRecord values;
	Locale locale;
	JsonEditor jsonEditor;
	Component comp;
	MTField mTField;
	Date date;
	
	
	boolean itShouldbeRemoved=false;
	
	public MultipleObjectBuilder() {
	}

	@Override
	public Component buildGridComponent(MTField mtField, Object value, IDetachedRecord values,Locale locale) {
		this.mTField=mtField;
		this.value=value;
		this.values=values;
		this.locale=locale;
		
		comp=new Div();
		
		((Div) comp).setSclass("btn btn-link");
		((Div) comp).setStyle("color:blue");
		Label label= new Label( MultipleHelper.getDescription( (ListValues<IDetachedRecord>) value,mtField,locale,3));
		label.setStyle("cursor:pointer");
		label.setParent(comp);
		
		comp.addEventListener(Events.ON_CLICK, this::multipleObjectEditor);
		return comp;
	}
	
	public void multipleObjectEditor(Event event) throws Exception {
		if(itShouldbeRemoved)return;
		CrudScreen screen=  new CrudScreen();
		MTField linkIn=MultipleHelper.getLinkIn(mTField);
		MTField parameter=((IDetachedRecord)values).getTable().getField(linkIn.getName());
		if(null==parameter) {
			for (MTField element : values.getFields()) {
				if(null!=linkIn.getForeignKey() && linkIn.getForeignKey().getPrimaryKey().equals(element.getSameAs())) {
					parameter=element;
					break;
					}
			}
		}
		screen.setFilterSection(new MapValues<Object>().add(linkIn.getName(), ((IDetachedRecord)values).get(parameter)));
		screen.init(mTField.getMultiRefTo(),comp);
		screen.build();
		itShouldbeRemoved=true;
		screen.doModal();
		itShouldbeRemoved=false;
	}

	public void jsonOnChange(Event event) throws Exception {
		Object previousdata = ((InputEvent) event).getPreviousValue();
		String data = previousdata.toString();
		try {
			 values.set(mTField,data);
			jsonEditor.getPanel().detach();
			Events.sendEvent(CustomEvents.ON_CHANGINGCONF, comp.getParent(), null);
		} catch (Exception e) {
			throw new ApiException(ApiError.DB_BAD_SQL, "Wrong Data in Db");
		}
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.MULTIPLEOBJECT;
	}
}
