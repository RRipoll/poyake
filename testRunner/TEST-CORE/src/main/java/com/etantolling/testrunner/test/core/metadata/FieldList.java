package com.etantolling.testrunner.test.core.metadata;

import java.util.Vector;

public class FieldList {
	public static int MODE_LIST = 0;
	public static int MODE_EDIT = 1;
	
	private MTTable table;
	private Vector<MTField> fields = new Vector<MTField>();
	
	private boolean showDeleted=true;
	
	public FieldList(MTTable table){
		this.table = table;
		for (MTField field:table.getFields().values()){
			fields.add(field);
		}
	}

	public void add(MTField field){
		fields.add(field);
	}
	
	public void remove(MTField field){
		fields.remove(field);
	}

	public void clear(){
		fields.clear();
	}
	
	public void autoRemove(int autoRemoveMode){
		Vector<MTField> fieldsToRemove = new Vector<MTField>();
		for (MTField field:fields){
			if (MODE_EDIT == autoRemoveMode){
				if (table.getPrimaryKey().equals(field)) fieldsToRemove.add(field);
				if ("LastModified".equalsIgnoreCase(field.getName())) fieldsToRemove.add(field);
			}
			if ("Created".equalsIgnoreCase(field.getName())) fieldsToRemove.add(field);
			if ("CreatedBy".equalsIgnoreCase(field.getName())) fieldsToRemove.add(field);
			if ("ModifiedBy".equalsIgnoreCase(field.getName())) fieldsToRemove.add(field);
			if ("Deleted".equalsIgnoreCase(field.getName())) fieldsToRemove.add(field);
			if ("InputSourceCode".equalsIgnoreCase(field.getName())) fieldsToRemove.add(field);
			if ("startdate".equalsIgnoreCase(field.getName())) fieldsToRemove.add(field);
			if ("starttestdate".equalsIgnoreCase(field.getName())) fieldsToRemove.add(field);
			if ("endtestdate".equalsIgnoreCase(field.getName())) fieldsToRemove.add(field);
			
			if ("enddate".equalsIgnoreCase(field.getName())) fieldsToRemove.add(field);
		}
		for (MTField field:fieldsToRemove) fields.remove(field); 
	}
	
	public Vector<MTField> getFields(){
		return fields;
	}
	
	public String getListSql(){
		String sColumns = "";
		for (MTField field:fields){
			if (0 != sColumns.length()) sColumns += ",";
			if (null==field.getForeignKey() || null == field.getForeignKey().getIdField())
				sColumns += field.getName();
			else
				
				sColumns += buildObjectIdQuery(field);
		}
		String sql = "select * from(select " + sColumns + " from " + table +" ";
				if(!showDeleted)sql+="where deleted not in (1) ";
				sql+=") where (1=1) ";
		return sql;
	}
	
	public String buildObjectIdQuery(MTField field){
		String sql = "(select " + field.getForeignKey().getIdField().getName(); 
		sql += " from " + field.getForeignKey();
		sql += " where " + field.getForeignKey().getPrimaryKey().getName() + " = " + table + "." + field.getName();
		sql += ")" + field.getName();
		return sql;
	}

	public boolean isShowDeleted() {
		return showDeleted;
	}

	public void setShowDeleted(boolean showDeleted) {
		this.showDeleted = showDeleted;
	}
}
