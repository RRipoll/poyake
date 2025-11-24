package com.jsantos.custom.cell;

import java.util.Locale;

import org.zkoss.zk.ui.Component;
import org.zkoss.zul.A;

import com.jsantos.custom.cell.IGridCellBuilder;
import com.jsantos.custom.cell.general.URLKeyGridCellBuilder;
import com.jsantos.metadata.MT;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class LastInvoiceGridCellBuilder   implements IGridCellBuilder {

	@Override
	public MTField forField() {

		return MT.VCUSTOMERSEARCH.LASTINVOICE;
	}

	@Override
	public Component buildGridComponent(MTField field, Object value, IDetachedRecord values,Locale locale) {
		if (null != value)
			return URLKeyGridCellBuilder.createComponent(values.get(MT.VCUSTOMERSEARCH.LASTINVOICEID).toString(),
					value,locale);
		return null;
	}

	@Override
	public MTDataType forModelType() {
		return null;
	}

	public static Component createComponent(String label, Object ref) {

		A a = new A();
		a.setLabel(label);
		if (null != ref) {
			a.setHref(ref.toString());
			a.setTarget("_blank");
		}
		return a;

	}

	

}
