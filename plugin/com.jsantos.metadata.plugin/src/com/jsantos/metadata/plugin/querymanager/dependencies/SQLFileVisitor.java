package com.jsantos.metadata.plugin.querymanager.dependencies;

import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.runtime.CoreException;

public class SQLFileVisitor implements IResourceProxyVisitor{
	ArrayList<IResource> resources;
	String projectName;


	public SQLFileVisitor(ArrayList<IResource> resources, String projectName) {
		this.resources = resources;
		this.projectName = projectName;
	}

	public boolean visit (IResourceProxy proxy) throws CoreException {
		if (proxy.getName().endsWith(".sql")) {
			IResource resource = proxy.requestResource();
			if (resource.getProject().getName().equals(projectName))
					resources.add(resource);
		}
		return true; 
	}

}
