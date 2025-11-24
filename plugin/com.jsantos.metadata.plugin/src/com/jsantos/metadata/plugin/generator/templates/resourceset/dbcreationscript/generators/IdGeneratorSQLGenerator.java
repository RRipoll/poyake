package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators;


import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.Sequence;

public class IdGeneratorSQLGenerator {
	
	public static String renderCreate(Entity entity, Vendor vendor){
		if (null == EntityHelper.getSequenceName(entity)) return null;
		if (!EntityHelper.isTable(entity)) return null;
		if (null == EntityHelper.getSinglePkAttribute(entity)) return null;
		
		switch(vendor) {
		case MYSQL:
			return "ALTER TABLE " + EntityHelper.getSimpleName(entity) + " AUTO_INCREMENT = 1001";
		default:
			return "CREATE SEQUENCE " + EntityHelper.getSequenceName(entity) + " START WITH 1000";
		}
	}

	public static String renderCreate(Sequence sequence, Vendor vendor){
		String retValue =  "CREATE SEQUENCE " + sequence.getName();
		if (null != sequence.getStartWith())
			retValue += " START WITH " + sequence.getStartWith();
		if (null != sequence.getIncrementBy())
			retValue += " INCREMENT BY " + sequence.getIncrementBy();
		if (null != sequence.getMinValue())
			retValue += " MINVALUE " + sequence.getMinValue();
		if (null != sequence.getMaxValue())
			retValue += " MAXVALUE " + sequence.getMaxValue();
		if (null != sequence.getCache())
			retValue += " CACHE " + sequence.getCache();
		if (sequence.isCycle())
			retValue += " CYCLE ";
		return retValue;
	}
	
	
	public static String renderDrop(Entity entity, Vendor vendor){
		if (null == EntityHelper.getSequenceName(entity)) return null;
		if (!EntityHelper.isTable(entity)) return null;
		if (null == EntityHelper.getSinglePkAttribute(entity)) return null;
		switch(vendor) {
		case MYSQL:
			return null;
		default:
			return "CREATE SEQUENCE " + EntityHelper.getSequenceName(entity) + " START WITH 1000";
		}
	}
	
	public static String renderAttribute(Entity entity, Attribute attribute, Vendor vendor) {
		switch (vendor) {
		case MYSQL:
			if (null != EntityHelper.getSinglePkAttribute(entity) && attribute == EntityHelper.getSinglePkAttribute(entity))
				return " AUTO_INCREMENT";
			else return "";

		default:
			return "";

		}
	}
	
}
