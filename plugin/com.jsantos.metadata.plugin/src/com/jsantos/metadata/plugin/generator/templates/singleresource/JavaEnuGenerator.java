package com.jsantos.metadata.plugin.generator.templates.singleresource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.accessors.PatternHelper;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.EnuMetadataRow;
import com.jsantos.metadata.plugin.metaDsl.EnumerationLabel;
import com.jsantos.metadata.plugin.metaDsl.Label;

public class JavaEnuGenerator {

	public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
		Iterators.<Entity>filter(resource.getAllContents(), Entity.class).forEachRemaining(
				entity -> {
					if (PatternHelper.entityImplementsPattern(entity, "Enumeration")) {
						String fileName = EntityHelper.getSimpleName(entity) + ".java";
						fileName = EntityHelper.getPackageName(entity).replace(".", "/") + "/" + fileName;
						fsa.generateFile(fileName , render(entity));
					}
				}
				);

	}

	public String render(Entity entity) {
		StringBuffer out = new StringBuffer();
		out.append("package " + EntityHelper.getPackageName(entity) + ";\r\n\r\n");
		out.append("import java.util.ArrayList;\r\n");
		out.append("import java.util.LinkedHashMap;\r\n");
		out.append("import com.jsantos.orm.mt.MTEnumeration;\r\n");
		out.append("import com.jsantos.orm.label.Label;\r\n\r\n");
		out.append("public class " );
		out.append(EntityHelper.getSimpleName(entity));
		out.append(" extends MTEnumeration{\r\n");
		out.append("\tstatic protected LinkedHashMap<Integer, String> values = new LinkedHashMap<>();\r\n");
		out.append("\tstatic protected LinkedHashMap<String, Integer> shortCodes = new LinkedHashMap<>();\r\n");
		out.append("\tstatic protected LinkedHashMap<Integer, ArrayList<Label>> labels = new LinkedHashMap<>();\r\n\r\n");
		

		outputEnumerationValues(entity, out);
		out.append("\r\n");
		outputStaticInit(entity, out);
		out.append("\r\n");
		out.append("\t@Override\r\n");
		out.append("\tpublic LinkedHashMap<Integer, String> getHashmap() {\r\n");
		out.append("\t\treturn values;\r\n");
		out.append("\t}\r\n");
		out.append("\r\n");
		out.append("\t@Override\r\n");
		out.append("\tpublic LinkedHashMap<String, Integer> getShortCodes() {\r\n");
		out.append("\t\treturn shortCodes;\r\n");
		out.append("\t}\r\n");
		out.append("\t@Override\r\n");
		out.append("\tpublic LinkedHashMap<Integer, ArrayList<Label>> getLabels() {\r\n");
		out.append("\t\treturn labels;\r\n");
		out.append("\t}\r\n");
		out.append("}");

		return out.toString();
	}


	void outputEnumerationValues(Entity entity, StringBuffer out) {
		if (null != entity.getEnuMetadata()){
			for (EnuMetadataRow row:entity.getEnuMetadata().getEnuMetadataRows()) {
				out.append("\tpublic static final int " + row.getName() + " = " + row.getKey() + ";\r\n");
			}
		}
	}
	
	void outputStaticInit(Entity entity, StringBuffer out) {
		out.append("\tstatic {\r\n");
		if (null != entity.getEnuMetadata()){
			for (EnuMetadataRow row:entity.getEnuMetadata().getEnuMetadataRows()) {
				out.append("\t\tvalues.put(" + row.getKey() + ",\"" + row.getDescription() + "\");\r\n");
				out.append("\t\tshortCodes.put(\"" + row.getName()  + "\"," + row.getKey() +");\r\n");
				out.append("\t\tlabels.put(" + row.getKey() + ", new ArrayList<Label>());\r\n");
			}
			if (null != entity.getEnumerationLabels()) {
				out.append("\r\n");
				for (EnumerationLabel labelSet:entity.getEnumerationLabels().getEnumerationLabel()) {
					for (Label label:labelSet.getLabels()) {
						out.append("\t\tlabels.get(" + labelSet.getEnuMetadataRow().getKey() + ").add( new Label(\"SHORTCODE\",\""+ label.getLang().getName() +"\",\"" + label.getLabelText() + "\"));\r\n");
					}
				}
			}
		}
		out.append("\t}\r\n");
		
	}

}
