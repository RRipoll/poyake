package com.jsantos.custom.cell.general;

import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.A;

import com.jsantos.custom.cell.IGridCellBuilder;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class URLKeyGridCellBuilder implements IGridCellBuilder {

	@Override
	public Component buildGridComponent(MTField field, Object value, IDetachedRecord values,Locale locale) {

		return createComponent(field.getName(), value,locale);
	}

	@Override
	public MTDataType forModelType() {
		return MTDataTypes.URL;
	}

	public static Component createComponent(String label, Object ref,Locale locale) {

		A a = new A();
		a.setLabel(label);
		if (null != ref) {
			a.setHref(ref.toString());
			a.setTarget("_blank");
		}
		return a;

	}

}
