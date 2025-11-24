package com.jsantos.common.fieldMapper;

import java.util.LinkedHashMap;

import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class FieldMapperComponentProvider {
	static final LinkedHashMap<String, IFieldMapper> byMTField = new LinkedHashMap<>();
	static final LinkedHashMap<String, IFieldMapper> byModelDataType = new LinkedHashMap<>();

	
	
	
	public static IFieldMapper getMapper(MTField field) {
		if (byMTField.containsKey(field.getFullyQualifiedName()))
			return  byMTField.get(field.getFullyQualifiedName());
		if (byModelDataType.containsKey(field.getDataType().getName()))
			return byModelDataType.get(field.getDataType().getName());
		return null;
		
	}
	
	
	

	public static void logBindings() {
		System.out.println(" Field Mapper Component Provider: =================================================");
		for (String modelDataType:byModelDataType.keySet())
			System.out.println("\t DataType: " + modelDataType + " -> " + byModelDataType.get(modelDataType).getClass().getSimpleName());
		for (String field:byMTField.keySet())
			System.out.println("\t Entity Field: " + field + " -> " + byMTField.get(field).getClass().getSimpleName());
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("");
	}


	public static void putBymtfield(MTField field, IFieldMapper container) {
		byMTField.put(field.getFullyQualifiedName(), container);
		
	}




	public static void putByModelDataType(MTDataType forModelType, IFieldMapper container) {
		byModelDataType.put(forModelType.getName(), container);
		
	}
	
}
