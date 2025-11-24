package com.jsantos.common.registry;

import java.util.LinkedHashMap;

import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class FieldRendererProvider {
	static final LinkedHashMap<String, IMTFieldRenderer> byMTField = new LinkedHashMap<>();
	static final LinkedHashMap<String, IMTFieldRenderer> byModelDataType = new LinkedHashMap<>();
	
	
	public static void initialize() {
		
	}
	
	
	public static IMTFieldRenderer getRenderer(MTField field) {
		if (byMTField.containsKey(field.getFullyQualifiedName()))
			return byMTField.get(field.getFullyQualifiedName());
		if (null!=field.getSameAs() && byMTField.containsKey(field.getSameAs().getFullyQualifiedName()))
			return byMTField.get(field.getSameAs().getFullyQualifiedName());
		if (byModelDataType.containsKey(field.getDataType().getName()))
			return byModelDataType.get(field.getDataType().getName());
		return null;
		
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


	public static void putBymtfield(MTField field, IMTFieldRenderer fieldRenderer) {
		byMTField.put(field.getFullyQualifiedName(), fieldRenderer);
		
	}


	public static void putByModelDataType(MTDataType forModelDataType, IMTFieldRenderer fieldRenderer) {
		byModelDataType.put(forModelDataType.getName(), fieldRenderer);
		
	}
	
}
