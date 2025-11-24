package com.jsantos.custom.cell;

import java.util.Locale;
import java.util.stream.Collectors;

import org.zkoss.zhtml.Text;
import org.zkoss.zk.ui.Component;
import org.zkoss.zul.Vbox;

import com.jsantos.common.util.ListValues;
import com.jsantos.metadata.MTtestRunnerData;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTHelper;

public class TrEventBuilder   implements IGridCellBuilder{


@Override
public Component buildGridComponent(MTField mtField, Object value, IDetachedRecord values, Locale locale) {
	
	Component comp=new Vbox();
	
	for (IDetachedRecord itement : (ListValues<IDetachedRecord>)value) {
		String text=MTHelper.getDescriptionFields(itement.getTable()).stream()
				.map(key -> key + " = " + itement.get(key))
	      .collect(Collectors.joining(", ", "{", "}"));
		new Text(text).setParent(comp);
	}
	return comp;
	
}

@Override
public MTField forField() {
	
	return MTtestRunnerData.TEST.EVENTS;
}

}
