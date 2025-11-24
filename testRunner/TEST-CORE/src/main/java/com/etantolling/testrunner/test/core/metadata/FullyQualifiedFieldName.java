package com.etantolling.testrunner.test.core.metadata;


public class FullyQualifiedFieldName {
	
	public static MTTable getMTTable(String fullyQualifiedFieldName){
		try{
			if (null != fullyQualifiedFieldName){
				if (fullyQualifiedFieldName.contains(".")){
					MTTable table = MTBase.getTable(fullyQualifiedFieldName.substring(0, fullyQualifiedFieldName.indexOf(".")));
					table.getField(fullyQualifiedFieldName.substring(fullyQualifiedFieldName.indexOf(".") + 1, fullyQualifiedFieldName.length()));
					return table;
				}
			}
		}
		catch (Exception e){
			throw new RuntimeException("Can't find fully qualified field name: " + fullyQualifiedFieldName );
		}
		throw new RuntimeException("Can't find fully qualified field name: " + fullyQualifiedFieldName );
		
	}
	
	public static MTField getMTField(String fullyQualifiedFieldName){
		try{
			if (null != fullyQualifiedFieldName){
				if (fullyQualifiedFieldName.contains(".")){
					MTTable table = MTBase.getTable(fullyQualifiedFieldName.substring(0, fullyQualifiedFieldName.indexOf(".")));
					MTField field = table.getField(fullyQualifiedFieldName.substring(fullyQualifiedFieldName.indexOf(".") + 1, fullyQualifiedFieldName.length()));
					return field;
				}
			}
		}
		catch (Exception e){
			throw new RuntimeException("Can't find fully qualified field name: " + fullyQualifiedFieldName );
		}
		throw new RuntimeException("Can't find fully qualified field name: " + fullyQualifiedFieldName );
	}
	
	public static String get(MTField field){
		return field.getTable().getTableName() + "." + field.getName();
	}
}
