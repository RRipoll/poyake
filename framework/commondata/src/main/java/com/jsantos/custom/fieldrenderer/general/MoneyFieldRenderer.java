package com.jsantos.custom.fieldrenderer.general;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

import com.jsantos.common.registry.IMTFieldRenderer;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.dbstatement.DBValueMapper;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class MoneyFieldRenderer implements IMTFieldRenderer{

	public MoneyFieldRenderer() {
	}
	
	@Override
	public MTDataType forModelDataType() {
		return MTDataTypes.MONEY;
	}

	@Override
	public String render(Object value,MTField mtField, IDetachedRecord values,Locale locale) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		df.setGroupingUsed(false);

		
		if (value == DBValueMapper.NULL) return "";
		if (null == value) return "";
		BigDecimal bdValue = new BigDecimal(value.toString());
		if (bdValue.compareTo(BigDecimal.ZERO)>=0)
			return "$" + df.format(value);
		else 
			return "($" + df.format(value).replace("-", "") + ")"; 
	}

	

}
