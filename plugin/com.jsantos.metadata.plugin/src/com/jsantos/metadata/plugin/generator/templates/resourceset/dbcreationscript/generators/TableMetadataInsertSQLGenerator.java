package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.Metadata;
import com.jsantos.metadata.plugin.metaDsl.MetadataRow;
import com.jsantos.metadata.plugin.metaDsl.MetadataRowCell;
import com.jsantos.metadata.plugin.validation.helpers.EntityValidator;

public class TableMetadataInsertSQLGenerator {

	public static final String QUOTE="'";

	public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
		Iterators.<Metadata>filter(resource.getAllContents(), Metadata.class).forEachRemaining(
				metadata -> 
				fsa.generateFile("sql/" + ((Entity)metadata.eContainer()).getName() + "_meta.sql", render(metadata, Vendor.DEFAULT))
				);

	}
	
	public static String render(Metadata metadata, Vendor vendor) {
		if (Vendor.ORACLE == vendor)
			return renderOracle(metadata);
		else
			return renderDefault(metadata);
	}

	
	public static String renderOracle(Metadata metadata) {
		StringBuffer out = new StringBuffer();
		out.append("insert all \r\n");

		for (MetadataRow row: metadata.getMetadataRows()) {

			Entity entity = (Entity)EntityValidator.getEntityforMetadata(metadata);
			out.append("into " );
			out.append(entity.getName());
			out.append("(");
			boolean comma = false;
			for (Attribute attribute:entity.getAttributes()) {
				if (null != attribute.getName()) {
					if (comma) out.append(",");
					else comma = true;
					out.append(attribute.getName());
				}
			}
			out.append(") values ");

			
			out.append("(");
			boolean cellComma = false;
			for (MetadataRowCell cell:row.getRowValues()) {
				if (cellComma)
					out.append(",");
				out.append(renderCellValue(row, cell, entity));
				cellComma = true;
			}
			out.append(")\r\n");
		}
		out.append("select 1 from dual \r\n");
		return out.toString();
		
	}
	
	static String getDefaultForCell(MetadataRow row, MetadataRowCell cell, Entity entity) {
		int rowIndex = row.getRowValues().indexOf(cell);
		if (null != entity.getAttributes().get(rowIndex).getDefault())
			return entity.getAttributes().get(rowIndex).getDefault();
		else
			if (null !=entity.getAttributes().get(rowIndex).getDefaultConstant())
				return entity.getAttributes().get(rowIndex).getDefaultConstant().getValue();
		return null;
	}
	
	public static String renderDefault(Metadata metadata) {
		StringBuffer out = new StringBuffer();
		out.append("insert into ");
		Entity entity = (Entity)EntityValidator.getEntityforMetadata(metadata);
		out.append(entity.getName());
		out.append("(");
		boolean comma = false;
		for (Attribute attribute:entity.getAttributes()) {
			if (null != attribute.getName()) {
				if (comma) out.append(",");
				else comma = true;
				out.append(attribute.getName());
			}
		}
		out.append(") values \r\n");

		comma=false;
		for (MetadataRow row: metadata.getMetadataRows()) {
			if (comma) out.append(",");
			else comma = true;
			out.append("(");

			boolean cellComma = false;
			for (MetadataRowCell cell:row.getRowValues()) {
				if (cellComma)
					out.append(",");
				out.append(renderCellValue(row, cell, entity));
				cellComma = true;
			}
			out.append(")\r\n");
		}
		return out.toString();
	}
	
	static String renderCellValue(MetadataRow row, MetadataRowCell cell, Entity entity) {
		if (cell.isIsNull())
			return "NULL";
		
		if (cell.isIsDefault())
			return getDefaultForCell(row, cell, entity);

		Attribute attribute = EntityHelper.getAttributeForCell(cell);
		if (null !=cell.getShortCode()) {
			return EntityHelper.getShortCodePk(attribute.getFkto(), cell.getShortCode().getShortCodeValue());
		}

		switch (attribute.getType().getName()) {
		case "INTEGER":
		case "BIT":
		case "NUMBER":
		case "DECIMAL":
			return cell.getStringValue();
		default:
			return QUOTE + cell.getStringValue() + QUOTE;
		}
	}

}
