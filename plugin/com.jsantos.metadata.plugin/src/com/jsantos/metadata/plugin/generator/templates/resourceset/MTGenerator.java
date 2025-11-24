package com.jsantos.metadata.plugin.generator.templates.resourceset;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.PluginConfig;
import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Configuration;
import com.jsantos.metadata.plugin.metaDsl.DataType;
import com.jsantos.metadata.plugin.metaDsl.DataTypeDetails;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.metaDsl.Label;
import com.jsantos.metadata.plugin.metaDsl.OverrideLabelBlock;
import com.jsantos.metadata.plugin.metaDsl.SubTypeDataType;

public class MTGenerator {
	static int nCountPaymentMethods = 0;
	//@Inject
	//private IContainer.Manager containerManager;
	//@Inject
	//private IAllContainersState.Provider stateProvider;
	
	
	public void test() {
		//containerManager.get
	}
	
	
	public void generate(XtextResourceSet rs, IFileSystemAccess fsa, String projectName) {
		test();
		LinkedHashMap<URI, String> mtResources = new LinkedHashMap<>();
		StringBuilder className = new StringBuilder("MT");
		StringBuffer out = new StringBuffer();
		out.append("package " + PluginConfig.getBasePackage() + ";\r\n\r\n" );
		out.append("import com.jsantos.orm.mt.MTBase; \r\n");
		LinkedHashMap<String, Entity> entities = new LinkedHashMap<String, Entity>();
		Vector<String> schemas = new Vector<>();

		// this will set the className for MT if the configuration contains MTCLASSNAME
		Iterators.<Configuration>filter(rs.getAllContents(), Configuration.class).forEachRemaining(
				configuration -> {
						String sResource = configuration.eResource().getURI().toString();
						if (StringUtils.isNotBlank(configuration.getMtClassName()) && sResource.startsWith("platform:/resource/" + projectName)) {
							className.setLength(0);
							className.append(configuration.getMtClassName());
						}
						if (StringUtils.isNotBlank(configuration.getMtClassName())) 
							mtResources.put(configuration.eResource().getURI(), configuration.getMtClassName());
					}
				);

		
		Iterators.<Entity>filter(rs.getAllContents(), Entity.class).forEachRemaining(
				entity -> {
					String sResource = entity.eResource().getURI().toString();
					if (!entities.keySet().contains(entity.getName()))
						entities.put(entity.getName(), entity);
				}
				);
		
		for (Entity entity:entities.values())
					if (null != EntityHelper.getSchema(entity) && !schemas.contains(EntityHelper.getSchema(entity)))
						schemas.add(EntityHelper.getSchema(entity));

		for (String schema:schemas)
			out.append("import " + EntityHelper.getPackageName(schema) + ".*;\r\n");
		
		
		out.append("\r\n");
		
		out.append("public class " + className + " extends MTBase{ \r\n");
		out.append("\tstatic boolean initialized = false;\r\n\r\n");
		for (Entity entity:entities.values()) 
				out.append("\tpublic static MTTable" + EntityHelper.getSimpleName(entity).toUpperCase() + " " + EntityHelper.getSimpleName(entity).toUpperCase() + ";\r\n");
		
		out.append("\r\n");
		out.append("\tpublic static void init(){\r\n");

		out.append("\t\tif (initialized) return;\r\n");
		out.append("\t\tinitialized = true;\r\n\r\n");
		
		for (Entry<URI, String> mtClassName:mtResources.entrySet())
			if (!projectName.equals(mtClassName.getKey()))
				out.append("\t\t" + mtClassName.getValue() + ".init();\r\n");
		
		for (Entity entity:entities.values()) {
			String mtClassName = mtResources.get(entity.eResource().getURI());
			if (null == mtClassName || entity.eResource().getURI().segment(1).equals(projectName))
				out.append("\t\t" + EntityHelper.getSimpleName(entity).toUpperCase() + " = new MTTable" + EntityHelper.getSimpleName(entity).toUpperCase() + "();\r\n");
			else
				out.append("\t\t" + EntityHelper.getSimpleName(entity).toUpperCase() + " = " + mtClassName + "." + EntityHelper.getSimpleName(entity).toUpperCase() + ";\r\n");
		}

		out.append("\r\n");
		
		for (Entity entity:entities.values()){
			out.append("\t\ttables.put(\"" + EntityHelper.getSimpleName(entity).toUpperCase() + "\", " + EntityHelper.getSimpleName(entity).toUpperCase() + ");\r\n");
			if (null !=entity.getExtends())
				out.append("\t\t" + EntityHelper.getSimpleName(entity).toUpperCase() + ".setExtendsTable(" + EntityHelper.getSimpleName(entity.getExtends()).toUpperCase() + ");\r\n");
		}

		out.append("\r\n");
		for (Entity entity:entities.values()) {
			for (Attribute attribute:entity.getAttributes()) {
				if (null != attribute.getFkto()) { 
					out.append("\t\tMTTable" + EntityHelper.getSimpleName(entity).toUpperCase() + "." + attribute.getName().toUpperCase() + ".setForeignKey(" + EntityHelper.getSimpleName(attribute.getFkto()).toUpperCase() + ");\r\n");
				}
				else if (null != attribute.getSameAsAttribute() && null !=attribute.getSameAsAttribute().getFkto())
					out.append("\t\tMTTable" + EntityHelper.getSimpleName(entity).toUpperCase() + "." + attribute.getName().toUpperCase() + ".setForeignKey(" + EntityHelper.getSimpleName(attribute.getSameAsAttribute().getFkto()).toUpperCase() + ");\r\n");
				if (null != attribute.getMultiRefTo()) {
					out.append("\t\tMTTable" + EntityHelper.getSimpleName(entity).toUpperCase() + "." + attribute.getName().toUpperCase() + ".setMultiRefTo(" + EntityHelper.getSimpleName(attribute.getMultiRefTo()).toUpperCase() + ");\r\n");
					
				}
			}
		}
		
		
		out.append("\r\n");
		Iterators.<OverrideLabelBlock>filter(rs.getAllContents(), OverrideLabelBlock.class).forEachRemaining(
				overrideLabelBlock -> {
					if (null != overrideLabelBlock.getAttribute()) {
						Attribute attr = overrideLabelBlock.getAttribute();
						Entity entity = EntityHelper.getEntityForObject(attr);
						for (Label label:overrideLabelBlock.getLabels()) {
							out.append("\t\tMTTable" + EntityHelper.getSimpleName(entity).toUpperCase() + "." + attr.getName().toUpperCase() + ".overrideLabel(\"" + overrideLabelBlock.getType() + "\",\"" + label.getLang().getName() + "\",\"" + label.getLabelText() + "\"); \r\n");
						}
					}
					if (null != overrideLabelBlock.getEntity()) {
						Entity entity = overrideLabelBlock.getEntity();
						for (Label label:overrideLabelBlock.getLabels()) {
							out.append("\t\t" + EntityHelper.getSimpleName(entity).toUpperCase() + ".overrideLabel(\"" + overrideLabelBlock.getType() + "\",\"" + label.getLang().getName() + "\",\"" + label.getLabelText() + "\"); \r\n");
						}
					}
				}
				);

		out.append("\t}\r\n");
		
		out.append("} \r\n\r\n");
		fsa.generateFile(PluginConfig.getBasePackage().replace(".", "/") + "/" + className + ".java" , out.toString());
		
		generateDataTypes(rs, fsa);
	}

	void generateDataTypes(XtextResourceSet rs, IFileSystemAccess fsa){
		ArrayList<String> types = new ArrayList<String>();
		
		StringBuffer out = new StringBuffer();
		out.append("package " + PluginConfig.getBasePackage() + ";\r\n\r\n" );
		out.append("import com.jsantos.orm.mt.MTDataType;\r\n\r\n");
		
		out.append("public class MTDataTypes { \r\n");
		
		
		Iterators.<DataType>filter(rs.getAllContents(), DataType.class).forEachRemaining(
				dataType -> {
					if (types.contains(dataType.getName()))
						out.append("\t //duplicated type " );
					else
						out.append("\t");
					out.append("public static final MTDataType " + dataType.getName() + "= new MTDataType(");
					out.append("\"" + dataType.getName() + "\"");
					
					if (dataType.getDetails() instanceof DataTypeDetails) {
						DataTypeDetails details = (DataTypeDetails) dataType.getDetails();
						out.append(",\"" + details.getDbNativeType() + "\"");
						out.append(",\"" + details.getJavaType() + "\"");
						out.append(",null");
						out.append("," + details.isWithPrecissionAndScale());
						out.append("," + details.isWithLength());
					}
					else {
						SubTypeDataType subTypeDataType = (SubTypeDataType) dataType.getDetails();
						DataTypeDetails details = (DataTypeDetails)subTypeDataType.getSubTypeOf().getDetails();
						out.append(",\"" + details.getDbNativeType() + "\"");
						out.append(",\"" + details.getJavaType() + "\"");
						out.append("," + subTypeDataType.getSubTypeOf().getName());
						if (null !=subTypeDataType.getLength() || details.isWithLength())
							out.append(",true");
						else
							out.append(",false");
						if (null != subTypeDataType.getScale() || details.isWithPrecissionAndScale())
							out.append(",true");
						else
							out.append(",false");
						
					}
					out.append(");\r\n");
					if (!types.contains(dataType.getName()))
						types.add(dataType.getName());
				}
				);
		
		out.append("} \r\n\r\n");
		fsa.generateFile(PluginConfig.getBasePackage().replace(".", "/") + "/MTDataTypes.java" , out.toString());
		
	}
	
}
