package com.jsantos.common.registry;

import java.util.Locale;

import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public interface IMTFieldRenderer {
	
	public default  MTField forField() {return null;};
	public default  MTDataType forModelDataType() {return null;}
	public String render(Object value,MTField mtField, IDetachedRecord values, Locale locale);
}
