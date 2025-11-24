package com.jsantos.metadata.plugin.accessors;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;

import com.jsantos.metadata.plugin.PluginConfig;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.EnuMetadataRow;
import com.jsantos.metadata.plugin.metaDsl.Metadata;
import com.jsantos.metadata.plugin.metaDsl.MetadataRow;
import com.jsantos.metadata.plugin.metaDsl.MetadataRowCell;

public class EntityHelper {
	
	public static Boolean isTable(Entity entity) {
		return (null == entity.getEntityType() || "TABLE".equals(entity.getEntityType()));
	}
	
	public static Attribute getSinglePkAttribute(Entity entity) {
		if (1 != getPks(entity).size()) {
			System.out.println("No single pk found for entity: " + entity.getName());
			return null;
		}
		for (Attribute attribute:entity.getAttributes()) {
			if (attribute.isPk())
				return attribute;
		}
		return null;
	}

	public static Attribute getAttributeByName(Entity entity, String attributeName) {
		for (Attribute attribute:entity.getAttributes()) {
			if (attribute.getName().equalsIgnoreCase(attributeName))
				return attribute;
		}
		return null;
	}

	public static List<Attribute> getPks(Entity entity) {
		Vector<Attribute> pks = new Vector<>();
		for (Attribute attribute:entity.getAttributes()) {
			if (attribute.isPk())
				pks.add(attribute);
		}
		return pks;
	}

	public static List<Entity> getReferencedEntities(Entity entity){
		Vector<Entity> referencedEntities = new Vector<>();
		for (Attribute attribute:entity.getAttributes())
			if (null != attribute.getFkto())
				referencedEntities.add(attribute.getFkto());
		return referencedEntities;
	}
	
	public static Attribute getAttributeForCell(MetadataRowCell cell) {
		MetadataRow metadataRow = null;
		if (cell.eContainer() instanceof MetadataRow) 
			metadataRow = (MetadataRow)cell.eContainer();
		if (cell.eContainer().eContainer() instanceof MetadataRow)
			metadataRow = (MetadataRow)cell.eContainer().eContainer();
		Entity entity = getEntityForObject(cell);
		int cellIndex = metadataRow.getRowValues().indexOf(cell);
		return entity.getAttributes().get(cellIndex);
	}

	public static Attribute getAttributeForEnumerationCell(MetadataRowCell cell) {
		EnuMetadataRow metadataRow = (EnuMetadataRow)cell.eContainer();
		Entity entity = (Entity)metadataRow.eContainer().eContainer();
		int cellIndex = metadataRow.getRowValues().indexOf(cell);
		return entity.getAttributes().get(cellIndex);
	}

	public static Vector<String> getAllShortCodes(Entity entity){
		Vector<String> shortCodes = new Vector<>();
		Attribute shortCodeAttribute = getAttributeByName(entity, "shortCode");
		if (null != shortCodeAttribute) {
			int index = entity.getAttributes().indexOf(shortCodeAttribute);
			for (MetadataRow row:entity.getMetadata().getMetadataRows()){
				MetadataRowCell cell = row.getRowValues().get(index);
				if (!cell.isIsNull())
					shortCodes.add(cell.getStringValue());
			}
		}
		return shortCodes;
	}
	
	public static Entity getEntityForObject(EObject o) {
		while(true) {
			if (o instanceof Entity)
				return (Entity)o;
			if (o instanceof Metadata)
				if (null !=((Metadata)o).getEntity())
					return ((Metadata)o).getEntity();
			o = o.eContainer();
			if (null == o)
				return null;
		}
	}
	
	public static String getSchema(Entity entity) {
		if (entity.getName().contains("."))
			return entity.getName().split("\\.")[0];
		else 
			return null;
	}

	public static String getSimpleName(Entity entity) {
		if (entity.getName().contains("."))
			return entity.getName().split("\\.")[1];
		else 
			return entity.getName();
	}

	public static String getShortCodePk(Entity entity, String shortCodeValue) {
		Attribute shortCodeAttribute = getAttributeByName(entity, "shortCode");
		Attribute primaryKeyAttribute = getSinglePkAttribute(entity);
		int shortCodeIndex = entity.getAttributes().indexOf(shortCodeAttribute);
		int primaryKeyIndex = entity.getAttributes().indexOf(primaryKeyAttribute);
		if (null !=entity.getMetadata() && null != entity.getMetadata().getMetadataRows()) {
			for (MetadataRow row:entity.getMetadata().getMetadataRows()) {
				if (row.getRowValues().get(shortCodeIndex).getStringValue().equals(shortCodeValue))
					return row.getRowValues().get(primaryKeyIndex).getStringValue();
			}
		}
		if (null !=entity.getEnuMetadata() && null != entity.getEnuMetadata().getEnuMetadataRows()) {
			for (EnuMetadataRow row:entity.getEnuMetadata().getEnuMetadataRows()) {
				if (row.getName().equals(shortCodeValue))
					return row.getKey();
			}
		}
		return "#ERROR#";
	}
	
	public static String getPackageName(Entity entity) {		
		String packageName = PluginConfig.getBasePackage();
		if (null != getSchema(entity))
			packageName += "." + getSchema(entity);
		return  packageName;
	}

	public static String getPackageName(String schema) {
		String packageName = PluginConfig.getBasePackage();
		if (null != schema)
			packageName += "." + schema;
		return  packageName;
	}
	
	public static String getSequenceName(Entity entity) {
		if (1 == getPks(entity).size()) {
			String fullName ="";
			if (null != getSchema(entity))
				fullName += getSchema(entity) + ".";
			fullName += "Seq_" + getSimpleName(entity) + "_" + EntityHelper.getPks(entity).get(0).getName();
			return fullName;
		}
		else
			return null;
	}
	
}
