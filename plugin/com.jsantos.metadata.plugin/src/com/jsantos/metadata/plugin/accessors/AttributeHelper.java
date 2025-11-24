package com.jsantos.metadata.plugin.accessors;

import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.DataTypeDetails;

public class AttributeHelper {

	public static String getRealDbNativeType(Attribute attribute) {
		return DataTypeHelper.getDbNativeType(attribute.getType());
	}
	
	public static DataTypeDetails getDataTypeDetails(Attribute attribute) {
		return DataTypeHelper.getDetails(attribute.getType());
	}

}
