package com.jsantos.custom.fieldrenderer.general;

import java.util.Locale;

import com.jsantos.common.i18n.MTLabels;
import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class EnumerationRenderer  implements IMTFieldRenderer{
	MTTable table;
	
	public EnumerationRenderer() {
	}
	
	public EnumerationRenderer(MTTable table) {
		if (null == table)
			throw new RuntimeException("table is null in ForeignKeyFieldRenderer initialization");
		this.table = table;
	}
	
	@Override
	public String render(Object value,MTField mtField, IDetachedRecord values,Locale locale) {
		if (value == DBValueMapper.NULL) return "";
		if (null == value) return "";

		return MTLabels.getLabel(table.getEnumeration(), (Integer)value,locale);
	}



}
