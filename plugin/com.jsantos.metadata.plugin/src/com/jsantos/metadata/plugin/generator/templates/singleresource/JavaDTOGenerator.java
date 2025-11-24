package com.jsantos.metadata.plugin.generator.templates.singleresource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.accessors.AttributeHelper;
import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.accessors.PatternHelper;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.MetadataRow;

public class JavaDTOGenerator {
	public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
		Iterators.<Entity>filter(resource.getAllContents(), Entity.class).forEachRemaining(
				entity -> {
					String fileName = EntityHelper.getPackageName(entity).replace(".", "/") + "/" + EntityHelper.getSimpleName(entity) + "DTO.java";
					fsa.generateFile(fileName , render(entity));
					System.out.println("Generating...");
					System.out.println(fsa.getURI(fileName));
					System.out.println(resource.getURI());
				}
				);
	}

	public String render(Entity entity) {
		StringBuffer out = new StringBuffer();
		out.append("package " + EntityHelper.getPackageName(entity) + ";\r\n\r\n");
		out.append("\r\n");
		out.append("import com.jsantos.orm.dbstatement.DetachedRecord;\r\n");
		out.append("import com.jsantos.orm.mt.MTBase;\r\n");
		out.append("import java.sql.ResultSet;\r\n");
		if (null !=entity.getExtends())
			out.append("import " + EntityHelper.getPackageName(entity.getExtends()) + ".*;\r\n");
		if (PatternHelper.entityImplementsPattern(entity, "AutoHistory"))
			out.append("import com.jsantos.orm.pattern.autohistory.AutoHistoryDetachedRecord;\r\n");
		out.append("\r\n");
		out.append("public class " );
		out.append(EntityHelper.getSimpleName(entity) +"DTO");
		if (PatternHelper.entityImplementsPattern(entity, "AutoHistory"))
			out.append(" extends AutoHistoryDetachedRecord{\r\n");
		else
			out.append(" extends DetachedRecord{\r\n");

		// constructors
		out.append("\r\n");
		out.append("\tpublic " + EntityHelper.getSimpleName(entity) +"DTO" + "(){\r\n");
		out.append("\t\tsuper(MTBase.getTable(\"" + EntityHelper.getSimpleName(entity).toUpperCase() + "\"));\r\n");
		out.append("\t}\r\n");
		// constructors
		out.append("\r\n");
		out.append("\tpublic " + EntityHelper.getSimpleName(entity) +"DTO" + "(ResultSet rs){\r\n");
		out.append("\t\tsuper(MTBase.getTable(\"" + EntityHelper.getSimpleName(entity).toUpperCase() + "\"), rs);\r\n");
		out.append("\t}\r\n");
		// constructors
		out.append("\r\n");
		out.append("\tpublic " + EntityHelper.getSimpleName(entity) +"DTO" + "(Integer pk) {\r\n");
		out.append("\t\tsuper(MTBase.getTable(\"" + EntityHelper.getSimpleName(entity).toUpperCase() + "\"), pk);\r\n");
		out.append("\t}\r\n");

		// constructors
		out.append("\r\n");
		out.append("\tpublic " + EntityHelper.getSimpleName(entity) +"DTO" + "(String whereClause) {\r\n");
		out.append("\t\tsuper(MTBase.getTable(\"" + EntityHelper.getSimpleName(entity).toUpperCase() + "\"), whereClause);\r\n");
		out.append("\t}\r\n");
	
		if (PatternHelper.entityImplementsPattern(entity, "AutoHistory")) {
			// constructors
			out.append("\r\n");
			out.append("\tpublic " + EntityHelper.getSimpleName(entity) +"DTO" + "(Boolean isMainFk, Integer pk) {\r\n");
			out.append("\t\tsuper(MTBase.getTable(\"" + EntityHelper.getSimpleName(entity).toUpperCase() + "\"),isMainFk, pk);\r\n");
			out.append("\t}\r\n");
			
		}
		
		out.append("\r\n");

		renderEntityAttributes(entity, out, false);
		
		//inheritance
		if (null != entity.getExtends()) {
			for (Entity en = entity.getExtends(); null !=en; en=en.getExtends()) {
				System.out.println("Render fields for : " + en.getName());
				renderEntityAttributes(en, out, true);
			}
		}
		
		out.append("\tpublic void update() {\r\n");
		out.append("\t\tsuper.update();\r\n");
		out.append("\t}\r\n");
		out.append("\r\n");
		out.append("\tpublic " + EntityHelper.getSimpleName(entity) +"DTO" + " insert() {\r\n");
		out.append("\t\treturn (" + EntityHelper.getSimpleName(entity) +"DTO) super.insert();\r\n");
		out.append("\t}\r\n");


		out.append("\r\n");
		out.append("\tpublic static " + EntityHelper.getSimpleName(entity) +"DTO" + " find(String whereExpression) {\r\n");
		out.append("\t\ttry {\r\n");
		out.append("\t\t\treturn new " + EntityHelper.getSimpleName(entity) + "DTO" + "(whereExpression);\r\n");
		out.append("\t\t}\r\n");
		out.append("\t\tcatch (Exception e) {\r\n");
		out.append("\t\t\tif (e.getMessage().contains(\"No records found\"))\r\n");
		out.append("\t\t\t\treturn null;\r\n");
		out.append("\t\t\telse\r\n");
		out.append("\t\t\t\tthrow e;\r\n");

		out.append("\t\t}\r\n");
		//out.append("\t\treturn (" + EntityHelper.getSimpleName(entity) + "DTO" + ")super.find(MT." + EntityHelper.getSimpleName(entity).toUpperCase() + ",whereExpression);\r\n");
		out.append("\t}\r\n");
		
		out.append("}");

		return out.toString();
	}

	
	void renderEntityAttributes(Entity ent, StringBuffer out, boolean superClass) {
		for (Attribute attribute:ent.getAttributes()) {
			if (null != attribute.getName()) {
				if (  !(attribute.isPk() && superClass) ) {
					//getter
					out.append("\tpublic ");
					out.append(AttributeHelper.getDataTypeDetails(attribute).getJavaType());
					out.append(" ");
					out.append(buildAccessorFunctionName(attribute.getName(), "get"));
					out.append("(){ \r\n");
					out.append("\t\treturn (" + AttributeHelper.getDataTypeDetails(attribute).getJavaType() + ") get(MTTable" + EntityHelper.getSimpleName(ent).toUpperCase() + "." + attribute.getName().toUpperCase() + ");\r\n");
					out.append("\t}\r\n");
					out.append("\r\n");

					//setter
					out.append("\tpublic void ");
					out.append(buildAccessorFunctionName(attribute.getName(), "set"));
					out.append("(" + AttributeHelper.getDataTypeDetails(attribute).getJavaType() + " " + attribute.getName() + ")");
					out.append("{ \r\n");
					out.append("\t\tset(MTTable" + EntityHelper.getSimpleName(ent).toUpperCase() + "." + attribute.getName().toUpperCase() + ", " + attribute.getName() + ");\r\n");
					out.append("\t} \r\n");
					out.append("\r\n");
				}
			}
		}
		
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
