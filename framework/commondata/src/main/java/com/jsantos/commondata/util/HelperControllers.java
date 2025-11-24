package com.jsantos.commondata.util;

import java.util.Map.Entry;

import com.jsantos.common.util.ListValues;
import com.jsantos.common.util.MTMapValues;
import com.jsantos.common.util.MapValues;
import com.jsantos.factory.DTOFactory;
import com.jsantos.metadata.MTDataTypes;
import com.jsantos.orm.mt.MTField;

public class HelperControllers {

	public static MapValues<Object> getJsonExampleValues(MTMapValues<Object> values) {
		
		MapValues<Object> retValue= new MapValues<Object>();
		
		for (Entry<MTField, Object> item : values.entrySet()) {
			if(item.getKey().getStereoTypes().contains("NOGUIINPUT"))continue;
			Object value=item.getValue();
			if(null!=item.getKey().getDefaultValue())value=item.getKey().getDefaultValue();
			else if(item.getKey().getDataType().equals(MTDataTypes.MULTIPLEENUM))
				value=new ListValues<Object>().addValue(getJsonExampleValues(DTOFactory.get(item.getKey().getMultiRefTo()).getCopyValues()));
			else if(item.getKey().getDataType().equals(MTDataTypes.MULTIPLEOBJECT))
				value=new ListValues<Object>().addValue(getJsonExampleValues(DTOFactory.get(item.getKey().getMultiRefTo()).getCopyValues()));
			else if(item.getKey().getDataType().getJavaType().equals("java.lang.String"))value="string";
			else if(item.getKey().getDataType().getJavaType().equals("java.lang.Integer"))value=0;
			else if(item.getKey().getDataType().getJavaType().equals("java.lang.Long"))value=0;
			else if(item.getKey().getDataType().getJavaType().equals("java.math.BigDecimal"))value=0.01;
			else if(item.getKey().getDataType().getJavaType().equals("java.lang.Float"))value=0.01;
			else if(item.getKey().getDataType().getJavaType().equals("java.sql.Date"))value="2099-01-01T23:28:56.782Z";
			else if(item.getKey().getDataType().getJavaType().equals("java.sql.Timestamp"))value="2099-01-01T23:28:56.782Z";
			else if(item.getKey().getDataType().getJavaType().equals("java.sql.Time"))value="2099-01-01T23:28:56.782Z";
			retValue.put(item.getKey().getName(), value);
		}
		return retValue;
	}
	
	
}
