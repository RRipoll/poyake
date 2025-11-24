package com.jsantos.custom.cell.general;

import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Div;
import org.zkoss.zul.Html;

import com.jsantos.custom.cell.IGridCellBuilder;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class HtmlCellBuilder extends Div implements IGridCellBuilder {

	@Override
	public Component buildGridComponent(MTField field, Object value, IDetachedRecord values,Locale locale) {
		
		new Html((String) value).setParent(this);
		
		return this;
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.HTML;
	}

}