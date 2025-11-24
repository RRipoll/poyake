package com.jsantos.metadata.plugin.accessors;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.resource.XtextResourceSet;

public class ResourceCollector {
	
	public XtextResourceSet collectResources(String projectName) throws CoreException {
		XtextResourceSet rSet = new XtextResourceSet();
		
		//Injector injector = new MetaDslStandaloneSetup().createInjectorAndDoEMFRegistration();
		
		
		ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).accept( new ResourceCollectorVisitor(rSet),IContainer.PROJECT);
		
		
		return rSet;
	}
}
