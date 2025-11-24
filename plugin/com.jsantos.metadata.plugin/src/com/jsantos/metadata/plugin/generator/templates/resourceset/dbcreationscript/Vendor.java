package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript;

public enum Vendor {
	DEFAULT("DEFAULT","Default","Default"),
	MYSQL("MYSQL","MySQL","MySQL"),
	SQLSERVER("SQLSERVER","SQL Server","SQL Server"),
	POSTGRESQL("POSTGRESQL","PostgreSQL JDBC Connection","PostgreSQL JDBC Connection"),
	ORACLE("ORACLE","Oracle","Oracle"),
	H2("H2","H2","H2")
	;
	
	private String value;
	private String description;
	private String eclipseConnectionManagerVendorString;
	
	Vendor (String value, String description, String eclipseConnectionManagerVendorString){
		this.value = value;
		this.description = description;
		this.eclipseConnectionManagerVendorString = eclipseConnectionManagerVendorString;
	}
	
	public String toString() {
		return value;
	}
	
	public String getDescription() {
		return description;
	}

	public String getEclipseConnectionManagerVendorString() {
		return eclipseConnectionManagerVendorString;
	}

	
}
