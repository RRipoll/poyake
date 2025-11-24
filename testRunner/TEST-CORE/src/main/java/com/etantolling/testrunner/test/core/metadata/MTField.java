package com.etantolling.testrunner.test.core.metadata;





public class MTField {
	
	private final String name;
	private Integer sqlType = null;
	private String nativeTypeName = null;
	private String subType = null;
	private Integer columnSize = null;
	private Integer decimalDigits = null;
	private Boolean nullable = false;
	private Boolean autoincrement = false;
	private Boolean primaryKey = false;
	private String foreignKey = null;
	private String tableNameOfEnumerationValues = null;
	private String tableName = null;
	
	public MTField(String name){
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public boolean isFileGroup(){
		if (null == getForeignKey()) return false;
		return "BO_FILEGROUP".equalsIgnoreCase(getForeignKey().toString());
	}
	
	public String getName() {
		return name;
	}

	public int getSqlType() {
		return sqlType;
	}

	public String getNativeTypeName() {
		return nativeTypeName;
	}

	public String getSubType() {
		if (isFileGroup()) return SubTypes.FILE_GROUP; // this could be set in Meta_Fields or just calculated as in here
		return subType;
	}

	public boolean isNullable() {
		return nullable;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public Integer getDecimalDigits() {
		return decimalDigits;
	}

	public boolean isAutoincrement() {
		return autoincrement;
	}

	public MTTable getForeignKey() {
		if (null == foreignKey) return null;
		return MTBase.getTable(foreignKey);
	}

	public void setSqlType(Integer sqlType) {
		this.sqlType = sqlType;
	}

	public void setNativeTypeName(String nativeTypeName) {
		this.nativeTypeName = nativeTypeName;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public void setDecimalDigits(Integer decimalDigits) {
		this.decimalDigits = decimalDigits;
	}

	public void setNullable(Boolean nullable) {
		this.nullable = nullable;
	}

	public void setNullable(int nullable) {
		this.nullable = 1==nullable;
	}
	
	public void setAutoincrement(Boolean autoincrement) {
		this.autoincrement = autoincrement;
	}

	public void setPrimaryKey(Boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
	}

	public Integer getColumnSize() {
		return columnSize;
	}

	public void setColumnSize(Integer columnSize) {
		this.columnSize = columnSize;
	}

	public MTTable getTableNameOfEnumerationValues() {
		return MTBase.getTable(tableNameOfEnumerationValues);
	}

	public void setTableNameOfEnumerationValues(String tableNameOfEnumerationValues) {
		this.tableNameOfEnumerationValues = tableNameOfEnumerationValues;
	}

	public MTTable getTable() {
		return MTBase.getTable(tableName);
	}

	public void setTable(String table) {
		this.tableName = table;
	}

	
}
