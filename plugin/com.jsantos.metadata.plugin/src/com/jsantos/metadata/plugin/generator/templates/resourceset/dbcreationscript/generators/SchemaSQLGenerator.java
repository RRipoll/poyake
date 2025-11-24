package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators;

public class SchemaSQLGenerator {
	public static String renderCreate(String schema) {
		return "CREATE SCHEMA " + schema;
	}
	
	public static String renderDrop(String schema) {
		return "DROP SCHEMA " + schema;
	}

}
