package com.jsantos.metadata.plugin.generator.templates.singleresource;

import java.util.Vector;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.accessors.PatternHelper;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.ColumnStereotype;
import com.jsantos.metadata.plugin.metaDsl.Configuration;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.IdGeneratorSequence;
import com.jsantos.metadata.plugin.metaDsl.Label;
import com.jsantos.metadata.plugin.metaDsl.LabelBlock;
import com.jsantos.metadata.plugin.metaDsl.MetadataRow;
import com.jsantos.metadata.plugin.metaDsl.Pattern;
import com.jsantos.metadata.plugin.metaDsl.SubTypeDataType;
import com.jsantos.metadata.plugin.metaDsl.TableStereotype;

public class JavaMTTableGenerator {
	public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
		Iterators.<Entity>filter(resource.getAllContents(), Entity.class).forEachRemaining(
				entity -> {
					if (entity.getAttributes().size()>0) {
						Configuration configuration = (Configuration)entity.getAttributes().get(0).getType().eContainer();
						String fileName = "MTTable" + EntityHelper.getSimpleName(entity).toUpperCase() + ".java";
						fileName = EntityHelper.getPackageName(entity).replace(".", "/") + "/" + fileName;
						fsa.generateFile(fileName , render(entity, configuration));
					}

				}
				);
	}	

	public String render(Entity entity, Configuration configuration) {
		StringBuffer out = new StringBuffer();
		out.append("package " + EntityHelper.getPackageName(entity) + ";\r\n\r\n");

		out.append("import java.util.ArrayList;\r\n" );
		out.append("import com.jsantos.orm.mt.MTField;\r\n" );
		out.append("import com.jsantos.orm.label.Label;\r\n" );
		out.append("import com.jsantos.metadata.MTDataTypes;\r\n");

		if (null != entity.getExtends())
			out.append("import com.jsantos.metadata.MT;\r\n");

		Vector<Entity> imports = new Vector<Entity>();
		for (Attribute attribute:entity.getAttributes()) {
			if (null != attribute.getSameAsAttribute()) {
				Entity importedEntity = EntityHelper.getEntityForObject(attribute.getSameAsAttribute());
				if (!imports.contains(importedEntity)) {
					imports.add(importedEntity);
					String mtTableName = "MTTable" + EntityHelper.getSimpleName(importedEntity).toUpperCase();
					String schemaName = "";
					if (null != EntityHelper.getSchema(importedEntity))
						schemaName=  EntityHelper.getSchema(importedEntity) + ".";
					out.append("import com.jsantos.metadata." + schemaName +  mtTableName + ";\r\n"); 
				}
			}
		}
		out.append("\r\n");

		out.append("public class MTTable" + EntityHelper.getSimpleName(entity).toUpperCase() + " extends com.jsantos.orm.mt.MTTable" );
		out.append("{\r\n");
		out.append("\tprivate static ArrayList<MTField> fields = new ArrayList<>();\r\n");
		out.append("\r\n");

		for (Attribute attribute:entity.getAttributes()) {
			if (null != attribute.getName()) {
				out.append("\t");
				if (null != attribute.getSameAsAttribute()) {
					out.append("public static MTField " + attribute.getName().toUpperCase());
					out.append(";");
					//String mtTableName = "MTTable" + EntityHelper.getSimpleName(EntityHelper.getEntityForObject(attribute.getSameAsAttribute())).toUpperCase();
					//out.append(" = new MTField(" + mtTableName + "." + attribute.getSameAsAttribute().getName().toUpperCase() + ",\"" + attribute.getName() +"\");\r\n");
				}
				else {
					out.append("public static final MTField " + attribute.getName().toUpperCase());
					out.append(" = new MTField(\"" + attribute.getName() + "\");");
				}
				out.append("\r\n");
			}
		}
		out.append("\r\n");

		out.append("\tpublic static void init(){\r\n");
		out.append("\t\tfields = new ArrayList<>();\r\n");
		for (Attribute attribute:entity.getAttributes()) {
			if (null !=attribute.getSameAsAttribute()) {
				Entity sameAsEntity = (Entity)attribute.getSameAsAttribute().eContainer();
				String mtTableName = "MTTable" + EntityHelper.getSimpleName(EntityHelper.getEntityForObject(attribute.getSameAsAttribute())).toUpperCase();
				out.append("\t\t" + attribute.getName().toUpperCase() + " = new MTField(" + mtTableName + "." + attribute.getSameAsAttribute().getName().toUpperCase() + ",\"" + attribute.getName() +"\");\r\n");

				if (null != sameAsEntity.getLabelSection() && null != sameAsEntity.getLabelSection().getLabels()) {
					for (LabelBlock labelBlock:sameAsEntity.getLabelSection().getLabels()) {
						if (null!=labelBlock.getAttribute() && labelBlock.getAttribute() == attribute.getSameAsAttribute()) {
							for (Label label:labelBlock.getLabels()) {
								String labelType = (null !=labelBlock.getType()?labelBlock.getType():"SHORTLABEL");
								out.append("\t\t\t" + attribute.getName().toUpperCase() + ".getLabels().add(new Label(\"" + labelType + "\",\"" + label.getLang().getName() + "\",\"" + label.getLabelText() + "\"));\r\n");
							}
						}
					}
				}

			}
			out.append("\t\tfields.add(" + attribute.getName().toUpperCase() +  ");\r\n");

			out.append("\t\t{\r\n");
			out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setDataType(MTDataTypes." + attribute.getType().getName() + ");\r\n");
			if (null != attribute.getLength())
				out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setLength(" + attribute.getLength() + ");\r\n");
			if (attribute.isMaxlength())
				out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setLength(-1);\r\n");
			if (attribute.getType().getDetails() instanceof SubTypeDataType) {
				SubTypeDataType subTypeDataType = (SubTypeDataType)attribute.getType().getDetails();
				if (subTypeDataType.isMaxlength())
					out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setLength(-1);\r\n");
				else {
					if (null != subTypeDataType.getScale())
						out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setScale(" + subTypeDataType.getScale() + ");\r\n");
					if (null != subTypeDataType.getLength())
						out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setLength(" + subTypeDataType.getLength() + ");\r\n");
				}
			}
			if (null != attribute.getScale())
				out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setScale(" + attribute.getScale() + ");\r\n");
			out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setNullable(" + !attribute.isNotNullable() +");\r\n");
			out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setTransient(" + attribute.isTransient() +");\r\n");
			if (null !=attribute.getIdGenerator() && null !=attribute.getIdGenerator().getTypeBlock() && attribute.getIdGenerator().getTypeBlock() instanceof IdGeneratorSequence)
				out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setSequence(\"" + ((IdGeneratorSequence) attribute.getIdGenerator().getTypeBlock()).getSequence().getName() + "\");\r\n");
			else if ("SEQUENCE".equals(configuration.getDefaultPkGenerationStrategy()) && attribute==EntityHelper.getSinglePkAttribute(entity) && null !=EntityHelper.getSequenceName(entity))
				out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setSequence(\"" + EntityHelper.getSequenceName(entity) + "\");\r\n");
			if (null !=entity.getLabelSection()) {
				for (LabelBlock labelBlock:entity.getLabelSection().getLabels()) {
					if (null!=labelBlock.getAttribute() && labelBlock.getAttribute() == attribute) {
						for (Label label:labelBlock.getLabels()) {
							String labelType = (null !=labelBlock.getType()?labelBlock.getType():"SHORTLABEL");
							out.append("\t\t\t" + attribute.getName().toUpperCase() + ".getLabels().add(new Label(\"" + labelType + "\",\"" + label.getLang().getName() + "\",\"" + label.getLabelText() + "\"));\r\n");
						}
					}
				}
			}

			if (null != attribute.getStereotypes()) {
				for (ColumnStereotype stereotype:attribute.getStereotypes()) {
					out.append("\t\t\t" + attribute.getName().toUpperCase() + ".getStereoTypes().add(\"" + stereotype.getName() + "\");\r\n");
				}
			}
			if (null != attribute.getMultiRefTo()) {
				
			}
			if (attribute.isPk())
				out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setPrimaryKey(true);\r\n");

			if (null != attribute.getDefault())
				out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setDefaultValue(\"" + attribute.getDefault() + "\");\r\n");
			if (null != attribute.getDefaultConstant())
				out.append("\t\t\t" + attribute.getName().toUpperCase() + ".setDefaultValue(\"" + attribute.getDefaultConstant().getValue() + "\");\r\n");

			out.append("\t\t}\r\n");
		}

		out.append("\t}\r\n\r\n");


		out.append("\tpublic MTTable" + EntityHelper.getSimpleName(entity).toUpperCase() + "(){\r\n");
		out.append("\t\tinit();\r\n");
		out.append("\t\tthis.tableName = \"" + EntityHelper.getSimpleName(entity) + "\";\r\n");
		if (null != EntityHelper.getSchema(entity))
			out.append("\t\tthis.schema = \"" + EntityHelper.getSchema(entity) + "\";\r\n");
		if (null != entity.getEntityType())
			out.append("\t\tthis.entityType = \"" + entity.getEntityType() + "\";\r\n");
		for(Attribute attribute:EntityHelper.getPks(entity)) {
			out.append("\t\tthis.primaryKeys.add(" + attribute.getName().toUpperCase() + ");\r\n");
		}
		if (null != entity.getPatterns()) {
			for (Pattern pattern:entity.getPatterns())
				out.append("\t\tthis.patterns.add(\"" + pattern.getName() + "\");\r\n");
		}
		if (null != entity.getStereotypes()) {
			for (TableStereotype stereotype:entity.getStereotypes())
				out.append("\t\tthis.stereotypes.add(\"" + stereotype.getName() + "\");\r\n");
		}
		if (null !=entity.getLabelSection()) {
			for (LabelBlock labelBlock:entity.getLabelSection().getLabels()) {
				if (labelBlock.isEntity()) {
					for (Label label:labelBlock.getLabels()) {
						String labelType = (null !=labelBlock.getType()?labelBlock.getType():"SHORTLABEL");
						out.append("\t\tthis.getLabels().add(new Label(\"" + labelType + "\",\"" + label.getLang().getName() + "\",\"" + label.getLabelText() + "\"));\r\n");
					}
				}
			}
		}
		if (null != entity.getQuerySourceBlock() && null != entity.getQuerySourceBlock().getQuerySource()) {
			String sqlSource = entity.getQuerySourceBlock().getQuerySource();
			sqlSource = sqlSource.substring(3, sqlSource.length()-3).replace("\r\n", " ").replace("\n", " ");
			out.append("\t\tthis.sql = \"" + sqlSource + "\";\r\n");
		}
		if (PatternHelper.entityImplementsPattern(entity, "Enumeration"))
			out.append("\t\tthis.enumeration= new " + EntityHelper.getSimpleName(entity) + "();\r\n");

		out.append("\t\tfor (MTField field:fields) field.setTable(this);\r\n");

		out.append("\t}\r\n\r\n");

		out.append("	@Override\n" + 
				"	public ArrayList<MTField> getFields() {\n" + 
				"		return fields;\n" + 
				"	}\n" + 
				"");

		out.append("}");

		return out.toString();
	}

	String buildAccessorFunctionName(String attributeName, String accessorType) {
		String firstLetter = attributeName.substring(0,1).toUpperCase();
		String restOfName = attributeName.substring(1, attributeName.length());
		return accessorType + firstLetter + restOfName;
	}


	void outputEnumerationValues(Entity entity, StringBuffer out) {
		int shortCodeIndex = entity.getAttributes().indexOf(EntityHelper.getAttributeByName(entity, "shortCode"));
		int pkIndex = entity.getAttributes().indexOf(EntityHelper.getSinglePkAttribute(entity));
		for (MetadataRow row:entity.getMetadata().getMetadataRows()) {
			out.append("\tpublic static final int " + row.getRowValues().get(shortCodeIndex).getStringValue() + " = " + row.getRowValues().get(pkIndex).getStringValue() + ";\r\n");
		}
	}

}
