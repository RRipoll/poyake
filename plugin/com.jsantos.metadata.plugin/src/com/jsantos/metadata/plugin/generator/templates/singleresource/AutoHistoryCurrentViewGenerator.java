package com.jsantos.metadata.plugin.generator.templates.singleresource;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

import com.google.common.collect.Iterators;
import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.accessors.PatternHelper;
import com.jsantos.metadata.plugin.metaDsl.Attribute;
import com.jsantos.metadata.plugin.metaDsl.Entity;

public class AutoHistoryCurrentViewGenerator {
	
	public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
		Iterators.<Entity>filter(resource.getAllContents(), Entity.class).forEachRemaining(
				entity -> {
					if (PatternHelper.entityImplementsPattern(entity, "Autohistory")) {
						String fileName = EntityHelper.getPackageName(entity).replace(".", "/") + "/view/Current" + EntityHelper.getSimpleName(entity) + ".sql";
						fsa.generateFile(fileName , render(entity));
					}
				}
				);
	}

	public String render(Entity entity) {
		StringBuffer out = new StringBuffer();
		out.append("create view ");
		if (StringUtils.isNotEmpty(EntityHelper.getSchema(entity)))
			out.append(EntityHelper.getSchema(entity) + ".");
		out.append("Current" + EntityHelper.getSimpleName(entity) + " as \r\n");
		out.append("select \r\n");
		for (Attribute attribute:entity.getAttributes()) {
			out.append("\t");
			if (entity.getAttributes().indexOf(attribute)>0)
				out.append(",");
			out.append(attribute.getName() + "\r\n");
		}
		out.append("from " + entity.getName() + " \r\n");
		out.append("where startDate<=getDate() and endDate>getDate()\r\n\r\n");
		
		
		return out.toString();
	}
}
