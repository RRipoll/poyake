package com.jsantos.search.registry;

import java.util.LinkedHashMap;

import com.jsantos.custom.sqlextended.ISqlExtended;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.search.sqlextended.SqlExtended;

public class SqlExtendedProvider {

	static final LinkedHashMap<String, ISqlExtended> byMTField = new LinkedHashMap<>();
	static final LinkedHashMap<String, ISqlExtended> byModelDataType = new LinkedHashMap<>();
	
	
	
	
	public static ISqlExtended getRenderer(MTField field) {
		if (byMTField.containsKey(field.getFullyQualifiedName()))
			return byMTField.get(field.getFullyQualifiedName());
		if (null!=field.getSameAs() && byMTField.containsKey(field.getSameAs().getFullyQualifiedName()))
			return byMTField.get(field.getSameAs().getFullyQualifiedName());
		if (byModelDataType.containsKey(field.getDataType().getName()))
			return byModelDataType.get(field.getDataType().getName());
		return new SqlExtended();
		
	}

	

	

	public static void logBindings() {
		System.out.println("Field Renderers: ===============================================");
		for (String modelDataType:byModelDataType.keySet())
			System.out.println("\t DataType: " + modelDataType + " -> " + byModelDataType.get(modelDataType).getClass().getSimpleName());
		for (String field:byMTField.keySet()) {
			System.out.print("\t Entity Field: " + field + " -> "); 
			System.out.println(byMTField.get(field).getClass().getSimpleName());
		}
		System.out.println("-----------------------------------------------------");
		System.out.println("");
	}





	public static void putBymtfield(MTField forField, SqlExtended sqlComponent) {
		byMTField.put(forField.getFullyQualifiedName(),sqlComponent);
		
	}





	public static void putByModelDataType(MTDataType forModelType, ISqlExtended sqlComponent) {
		byModelDataType.put(forModelType.getName(), sqlComponent);
		
	}
	
	
	
}
