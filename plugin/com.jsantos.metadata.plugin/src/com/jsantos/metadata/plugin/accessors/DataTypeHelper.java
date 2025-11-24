package com.jsantos.metadata.plugin.accessors;

import com.jsantos.metadata.plugin.metaDsl.DataType;
import com.jsantos.metadata.plugin.metaDsl.DataTypeDetails;
import com.jsantos.metadata.plugin.metaDsl.SubTypeDataType;

public class DataTypeHelper {
	
	public static String getDbNativeType(DataType dataType) {
		if (getDetails(dataType) instanceof DataTypeDetails) return ((DataTypeDetails)getDetails(dataType)).getDbNativeType();
		return ((DataTypeDetails)((SubTypeDataType)getDetails(dataType)).getSubTypeOf()).getDbNativeType();
	}
	
	public static DataTypeDetails getDetails(DataType dataType) {
		if (dataType.getDetails() instanceof DataTypeDetails) return ((DataTypeDetails)dataType.getDetails());
		return (DataTypeDetails)((SubTypeDataType)dataType.getDetails()).getSubTypeOf().getDetails();
	}
}
