package com.jsantos.custom.customfield;

import java.util.LinkedHashMap;

import com.jsantos.orm.mt.MTDataType;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTable;

public class CustomFieldContainerProvider {
	
	static final LinkedHashMap<String, IMTComponent> byMTField = new LinkedHashMap<>();
	static final LinkedHashMap<String, IMTComponent> byModelDataType = new LinkedHashMap<>();
	static final LinkedHashMap<String, IMTComponent> byPkTable = new LinkedHashMap<>();
		

	
	public static IMTComponent getCustomFieldContainer(MTField field){
		try {
			IMTComponent retValue;
		
			if (byMTField.containsKey(field.getFullyQualifiedName()))
				retValue= byMTField.get(field.getFullyQualifiedName()).getClass().newInstance();
			else if (null!=field.getSameAs() && byMTField.containsKey(field.getSameAs().getFullyQualifiedName()))
				retValue= byMTField.get(field.getSameAs().getFullyQualifiedName()).getClass().newInstance();
			else if (byModelDataType.containsKey(field.getDataType().getName()))
				retValue= byModelDataType.get(field.getDataType().getName()).getClass().newInstance();
			else if (null!=field.getForeignKey() && byPkTable.containsKey(field.getForeignKey().getTableName())) {
				retValue= byPkTable.get(field.getForeignKey().getTableName()).getClass().newInstance();
			}else if(null!=field.getForeignKey() 
					&& !field.getForeignKey().getIsEnumeration()) {
				PkFieldContainer comp= new PkFieldContainer();
				comp.setMtField(field);
				return comp;
			}else retValue= new DefaultMTCustomFieldContainer();
			retValue.setMTField(field);
		
			return retValue;
			}
		catch (InstantiationException| IllegalAccessException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	
	public static void logBindings() {
		System.out.println("Custom Field Containers: ===============================================");
		
		
		for (String modelDataType:byModelDataType.keySet())
			System.out.println("Custom Field Component Provider: " + modelDataType + " -> " + byModelDataType.get(modelDataType).getClass().getSimpleName());
		for (String field:byMTField.keySet())
			System.out.println("Custom Field Component Provider: " + field + " -> " + byMTField.get(field).getClass().getSimpleName());
		for (String table:byPkTable.keySet())
			System.out.println("Custom Field PK Component Provider: " + table + " -> " + byPkTable.get(table).getClass().getSimpleName());
		
		
		System.out.println("-----------------------------------------------------");
		System.out.println("");
	}



	public static void putByPkTable(MTTable table, IMTComponent container) {
		byPkTable.put(table.getTableName(), container);
		
	}



	public static void putBymtfield(MTField mtField, IMTComponent container) {
		byMTField.put(mtField.getFullyQualifiedName(), container);
		
	}



	public static void putByModelDataType(MTDataType forModelType, IMTComponent container) {
		
		byModelDataType.put(forModelType.getName(), container);
	}

	
	
	
	
	
}
