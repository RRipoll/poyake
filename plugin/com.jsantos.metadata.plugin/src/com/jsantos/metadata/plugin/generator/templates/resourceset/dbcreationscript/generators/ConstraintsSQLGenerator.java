package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators;

import java.util.ArrayList;
import java.util.List;

import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;

public class ConstraintsSQLGenerator {
	
	public static List<String> render(Entity entity){
		ArrayList<String> statements = new ArrayList<>();
		for (Attribute attribute:entity.getAttributes()) {
			if (attribute.isUnique())
				statements.add("ALTER TABLE " + EntityHelper.getSimpleName(entity) + " ADD CONSTRAINT UQ_" + EntityHelper.getSimpleName(entity) + "_" + attribute.getName() + " UNIQUE(" + attribute.getName() + ")");
		}
		return statements;
	}
	
	public static List<String>renderDrop(Entity entity){
		ArrayList<String> statements = new ArrayList<>();
		return statements;
	}	
}
