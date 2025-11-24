package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.EnuMetadata;
import com.jsantos.metadata.plugin.metaDsl.EnuMetadataRow;
import com.jsantos.metadata.plugin.metaDsl.MetadataRowCell;

public class EnuMetadataInsertSqlGenerator {
	public static final String QUOTE="'";

	public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
		Iterators.<EnuMetadata>filter(resource.getAllContents(), EnuMetadata.class).forEachRemaining(
				metadata -> 
				fsa.generateFile("sql/" + ((Entity)metadata.eContainer()).getName() + "_meta.sql", render(metadata, Vendor.DEFAULT))
				);

	}
	
	public static String render(EnuMetadata metadata, Vendor vendor) {
		if (Vendor.ORACLE == vendor)
			return renderOracle(metadata);
		else
			return renderDefault(metadata);
	}

	
	public static String renderOracle(EnuMetadata metadata) {
		StringBuffer out = new StringBuffer();
		out.append("insert all \r\n");

		for (EnuMetadataRow row: metadata.getEnuMetadataRows()) {

			Entity entity = (Entity)metadata.eContainer();
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
			out.append(row.getKey());
			out.append(",");
			out.append("'" + row.getName() + "',");
			out.append("'" + row.getDescription() + "'");
			for (MetadataRowCell cell:row.getRowValues()) {
				out.append(",");
				out.append(renderCellValue(row, cell, entity));
			}
			out.append(")\r\n");
		}
		out.append("select 1 from dual \r\n");
		return out.toString();
		
	}
	
	static String getDefaultForCell(EnuMetadataRow row, MetadataRowCell cell, Entity entity) {
		int rowIndex = 3+ row.getRowValues().indexOf(cell);
		return entity.getAttributes().get(rowIndex).getDefault();
	}
	
	public static String renderDefault(EnuMetadata metadata) {
		try {
			StringBuffer out = new StringBuffer();
			out.append("insert into ");
			Entity entity = (Entity)metadata.eContainer();
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
			for (EnuMetadataRow row: metadata.getEnuMetadataRows()) {
				if (comma) out.append(",");
				out.append("(");
				out.append(row.getKey());
				out.append(",");
				out.append("'" + row.getName() + "',");
				out.append("'" + row.getDescription() + "'");
	
				for (MetadataRowCell cell:row.getRowValues()) {
					out.append(",");
					out.append(renderCellValue(row, cell, entity));
				}
				out.append(")\r\n");
				comma = true;
			}
			return out.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	static String renderCellValue(EnuMetadataRow row, MetadataRowCell cell, Entity entity) {
		if (cell.isIsNull())
			return "NULL";
		
		if (cell.isIsDefault())
			return getDefaultForCell(row, cell, entity);

		Attribute attribute = EntityHelper.getAttributeForEnumerationCell(cell);
		if (null !=cell.getShortCode() && null !=attribute.getFkto()) {
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

