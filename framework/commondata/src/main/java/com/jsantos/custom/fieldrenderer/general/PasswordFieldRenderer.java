package com.jsantos.custom.fieldrenderer.general;

import java.util.Locale;

import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class PasswordFieldRenderer implements IMTFieldRenderer{

	public PasswordFieldRenderer() {
	}
	
	@Override
	public MTDataType forModelDataType() {
		return MTDataTypes.PASSWORD;
	}

	@Override
	public String render(Object value,MTField mtField, IDetachedRecord values,Locale locale) {
		if (value == DBValueMapper.NULL) return "";
		if (null == value) return "";
		return "*********";
	}

	

}
