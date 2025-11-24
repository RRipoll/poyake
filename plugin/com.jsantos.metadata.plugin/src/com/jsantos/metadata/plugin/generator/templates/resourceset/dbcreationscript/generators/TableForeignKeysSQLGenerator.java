package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators;

import java.util.List;
import java.util.Vector;

import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;

public class TableForeignKeysSQLGenerator {
	
	public static List<String>render(Entity entity){
		
		Vector<String> statements = new Vector<>();
		if (!"TABLE".equals(entity.getEntityType()))
			return statements;

		for (Attribute attribute:entity.getAttributes()) {
			if (null != attribute.getFkto()) {
				StringBuffer statement = new StringBuffer();
				statement.append("ALTER TABLE ");
				statement.append(entity.getName());		
				statement.append(" ADD CONSTRAINT ");
				String constraintName = "FK";
				if (null != EntityHelper.getSchema(entity))
					constraintName += "_" + EntityHelper.getSchema(entity);
				constraintName += "_" + EntityHelper.getSimpleName(entity) + "_" + attribute.getName();
				statement.append(constraintName);
				statement.append(" FOREIGN KEY(" + attribute.getName() + ") ");
				statement.append(" REFERENCES " + attribute.getFkto().getName());
				statement.append("("  + EntityHelper.getSinglePkAttribute(attribute.getFkto()).getName() + ")");
				statements.add(statement.toString());
			}
		}
		return statements;
	}
	
	public static List<String>renderDrop(Entity entity){
		Vector<String> statements = new Vector<>();
		if (!"TABLE".equals(entity.getEntityType()))
			return statements;
		
		for (Attribute attribute:entity.getAttributes()) {
			if (null != attribute.getFkto()) {
				StringBuffer statement = new StringBuffer();
				statement.append("ALTER TABLE ");
				statement.append(entity.getName());		
				statement.append(" DROP CONSTRAINT FK_");
				statement.append(EntityHelper.getSimpleName(entity) + "_" + attribute.getName() );
				statements.add(statement.toString());
			}
		}
		return statements;
		
	}

}
