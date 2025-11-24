package com.jsantos.common.constraint;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.jsantos.common.util.ListValues;
import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;

public class ConstraintsComponentProvider {
	
	static final Map<String, ListValues<IConstraintsBuilder>> byMTField = new LinkedHashMap<>();
	static final Map<String, ListValues<IConstraintsBuilder>> byModelDataType = new LinkedHashMap<>();
	
	
	
	public static ListValues<IConstraintsBuilder> getConstraintsComponent(MTField mtField){
		ListValues<IConstraintsBuilder> constraints= new ListValues<>();

		if (byMTField.containsKey(mtField.getFullyQualifiedName()))
			constraints.addAll(byMTField.get(mtField.getFullyQualifiedName()));
		if (null!=mtField.getSameAs() && byMTField.containsKey(mtField.getSameAs().getFullyQualifiedName()))
			constraints.addAll(byMTField.get(mtField.getSameAs().getFullyQualifiedName()));
		if (byModelDataType.containsKey(mtField.getDataType().getName()))
			constraints.addAll(byModelDataType.get(mtField.getDataType().getName()));
		

		return constraints;
	}
	
	
	

	public static void logBindings() {
		for (String modelDataType:byModelDataType.keySet())
			for (IConstraintsBuilder iConstraintsBuilder : byModelDataType.get(modelDataType)) 
				System.out.println("Field Component Provider: " + modelDataType + " -> " + iConstraintsBuilder.getClass().getSimpleName());
		for (String field:byMTField.keySet())
			for (IConstraintsBuilder iConstraintsBuilder : byMTField.get(field)) 
			System.out.println("Field Component Provider: " + field+ " -> " + iConstraintsBuilder.getClass().getSimpleName());
		
	}

	public static List<IConstraintsBuilder> getBymtfield(MTField field) {
		return byMTField.get(field.getFullyQualifiedName());
	}

	public static void putBymtfield(MTField field, ListValues<IConstraintsBuilder> listValues) {
		byMTField.put(field.getFullyQualifiedName(), listValues);
		
	}




	public static List<IConstraintsBuilder> getByModelDataType(MTDataType forModelType) {
		return byModelDataType.get(forModelType.getName());
	}




	public static void putByModelDataType(MTDataType forModelType, ListValues<IConstraintsBuilder> listValues) {
		byModelDataType.put(forModelType.getName(), listValues);
		
	}
}
