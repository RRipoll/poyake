package com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.generators;


import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.accessors.AttributeHelper;
import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.SqlFileDependency;
import com.jsantos.metadata.plugin.metaDsl.SubTypeDataType;
import com.jsantos.metadata.plugin.util.EclipseFileUtil;

public class TableCreateSQLGenerator {

	public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
		Iterators.<Entity>filter(resource.getAllContents(), Entity.class).forEachRemaining(
				entity -> 
				fsa.generateFile("sql/" + entity.getName() + ".sql", renderCreate(entity, Vendor.DEFAULT, null))
				);
	}

	public static String renderCreate(Entity entity, Vendor vendor, DependencySqlGenerator dependencySqlGenerator) {
		if (null != entity.getEntityType() && !"TABLE".equalsIgnoreCase(entity.getEntityType())) return null;
		
		StringBuffer out = new StringBuffer();
		
		//dependencies
		if (null !=entity.getSqlFileDependencies()) {
			for (SqlFileDependency dependency:entity.getSqlFileDependencies()) {
				try {
					String fileName = dependency.getSqlFileDependency();
					URI uri = EclipseFileUtil.buildFileURI(entity, fileName);
					dependencySqlGenerator.render(out, uri, fileName);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		//create table
		out.append("CREATE TABLE " );
		out.append(entity.getName());
		out.append("(\r\n");
		for (Attribute attribute:entity.getAttributes()) {
			if (null != attribute.getName()) {
				out.append("\t");
				out.append(attribute.getName());
				out.append(" ");
				out.append(buildAttributeType(entity, attribute, vendor));
				out.append(IdGeneratorSQLGenerator.renderAttribute(entity, attribute, vendor));
				if (null !=attribute.getDefault())
					out.append(" DEFAULT " + attribute.getDefault());
				if (null !=attribute.getDefaultConstant())
					out.append(" DEFAULT " + attribute.getDefaultConstant().getValue());
				if (attribute.isNotNullable())
					out.append(" NOT NULL ");
				if (attribute.isUnique())
					out.append(" UNIQUE ");
				
				if (entity.getAttributes().indexOf(attribute)<(entity.getAttributes().size()-1))
					out.append(",");
				
				out.append("\r\n");
			}
		}
		List<Attribute> primaryKeys=EntityHelper.getPks(entity);
		if (primaryKeys.size()>0) {
			String constraintName = "PK";
			if (null != EntityHelper.getSchema(entity))
				constraintName += "_" + EntityHelper.getSchema(entity);
			constraintName += "_" + EntityHelper.getSimpleName(entity);
			out.append(",CONSTRAINT " + constraintName + " PRIMARY KEY ("  );
			for (Attribute attribute:primaryKeys) {
				if (primaryKeys.indexOf(attribute)>0)
					out.append(",");
				out.append(attribute.getName());
			}
			out.append(")");
				
		}
		out.append(")");

		return out.toString();
	}

	public static String renderDrop(Entity entity) {
		if (null != entity.getEntityType() && !"TABLE".equalsIgnoreCase(entity.getEntityType())) return null;
		return "drop table " + entity.getName();
	}
	
	static String buildAttributeType(Entity entity, Attribute attribute, Vendor vendor) {
		String sType = AttributeHelper.getRealDbNativeType(attribute);
		if (null !=attribute.getLength()||attribute.isMaxlength() && vendor == Vendor.SQLSERVER) { 
			sType += "(";
			if (null !=attribute.getLength())
				sType += attribute.getLength();
			if (attribute.isMaxlength())
				sType += "max";
			if (null != attribute.getScale())
				sType += "," + attribute.getScale();
			sType += ")";
		}
		else if (attribute.getType().getDetails() instanceof SubTypeDataType) {
			SubTypeDataType subTypeDataType = (SubTypeDataType)attribute.getType().getDetails();
			if (subTypeDataType.isMaxlength() && vendor == Vendor.SQLSERVER)
				sType += "(MAX)";
			else if (null !=subTypeDataType.getLength()) { 
				sType += "(" + subTypeDataType.getLength();
				if (null != subTypeDataType.getScale())
					sType += "," + subTypeDataType.getScale();
				sType += ")";
			}
		}


		return sType;
	}

}
