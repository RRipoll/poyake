package com.jsantos.metadata.plugin.querymanager.dependencies;

import java.util.ArrayList;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

public class ResourceCollector {
	
	public ArrayList<IResource> collectResources(String projectName) throws CoreException {
		ArrayList<IResource> resources = new ArrayList<>();
		ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).accept( new SQLFileVisitor(resources, projectName),IContainer.PROJECT);
		
		
		return resources;
	}
}
