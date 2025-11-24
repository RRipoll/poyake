package com.jsantos.metadata.plugin.accessors;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

public class ResourceCollectorVisitor implements IResourceProxyVisitor{
	XtextResourceSet rSet;
	String projectName;


	public ResourceCollectorVisitor(XtextResourceSet rSet) {
		this.rSet=rSet;

	}

	public boolean visit (IResourceProxy proxy) throws CoreException {
		if (proxy.getName().endsWith(".metadata")) {
			rSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
			//String fileURI = proxy.requestResource().getLocationURI().toString();
			IResource resource = proxy.requestResource();
//			IPath iPath = resource.getProject().getFullPath();
			//String platformUri = "platform:/resource" + fileURI.substring(fileURI.indexOf(iPath.toString()), fileURI.length());
			String platformUri2 = "platform:/resource" + resource.getFullPath();
			rSet.getResource(URI.createURI(platformUri2), true);
			proxy.getClass();
				

		}
		return true; 
	}

}
