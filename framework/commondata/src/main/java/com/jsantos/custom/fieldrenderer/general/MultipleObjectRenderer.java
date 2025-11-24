package com.jsantos.custom.fieldrenderer.general;

import java.util.Locale;

import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.common.util.ListValues;
import com.jsantos.commondata.util.MultipleHelper;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class MultipleObjectRenderer implements IMTFieldRenderer {

	public MultipleObjectRenderer() {
	}

	@Override
	public MTDataType forModelDataType() {
		return MTDataTypes.MULTIPLEOBJECT;
	}

	@Override
	public String render(Object value,MTField mtField, IDetachedRecord dtr, Locale locale) {
	return MultipleHelper.getDescription((ListValues<IDetachedRecord>) value,mtField,locale,3);
	}

	

}
