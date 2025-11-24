package com.jsantos.metadata.plugin.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;

import com.jsantos.metadata.plugin.generator.templates.singleresource.JavaDTOGenerator;
import com.jsantos.metadata.plugin.generator.templates.singleresource.JavaEnuGenerator;
import com.jsantos.metadata.plugin.generator.templates.singleresource.JavaMTTableGenerator;
import com.jsantos.metadata.plugin.util.Logger;


public class MetaDslGeneratorImp extends AbstractGenerator {

	@Override
	public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
		try {
			if (resource.getErrors().size()==0) {
				//new TableCreateSQLGenerator().doGenerate(resource, fsa, context);
				//new TableMetadataInsertSQLGenerator().doGenerate(resource, fsa, context);
				new JavaEnuGenerator().doGenerate(resource, fsa, context);
				new JavaDTOGenerator().doGenerate(resource, fsa, context);
				new JavaMTTableGenerator().doGenerate(resource, fsa, context);
				//new AutoHistoryCurrentViewGenerator().doGenerate(resource, fsa, context);
			}
		}
		catch (Throwable e) {
			e.printStackTrace();
			Logger.error("Error generating java objects", e);
		}


	}


}
