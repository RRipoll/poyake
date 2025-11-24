package com.jsantos.metadata.plugin.ui.util;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.jsantos.metadata.plugin.ui.MetaDslExecutableExtensionFactory;
import com.jsantos.metadata.plugin.util.Logger;

public class ResourceSetLoader extends MetaDslExecutableExtensionFactory{

	/*
	@Inject
	private IResourceDescription.Manager descriptionManager;
	*/
	
	boolean resolveAll = false;
	
	
	public XtextResourceSet buildResourceSet(String projectName, boolean resolveAll, List<URI> archiveURIs) throws CoreException {
		
		Provider<XtextResourceSet> xtextResourceSetProvider = getInjector().getInstance(new Key<Provider<XtextResourceSet>>() {});

		XtextResourceSet resourceSet = xtextResourceSetProvider.get();
		if (resolveAll)
			resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		/*
		ResourceCollectorVisitor visitor = new ResourceCollectorVisitor(resourceSet);
		//ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).accept( visitor,IContainer.PROJECT); 
		ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).accept( visitor,IContainer.INCLUDE_HIDDEN | IContainer.DEPTH_INFINITE); 
		
		for (IProject referencedProject:ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getReferencedProjects()) 
			referencedProject.accept(visitor,IContainer.PROJECT);
		
		//URI uri = URI.createURI("archive:file:/home/jsantos/.m2/repository/com/poyake/poyake-file/0.0.4-SNAPSHOT/poyake-file-0.0.4-SNAPSHOT.jar!/metadata/common/table/StorageFile.metadata");
		//resourceSet.getResource(uri,  true);
		*/
		
		
		if (null != archiveURIs)
			for (URI uri:archiveURIs) {
				//for (Resource resource:resourceSet.getResources())
				//	if (new File(resource.getURI().toFileString()).getName().equals(new File(uri.toFileString()).getName()))
				//		Logger.error("Duplicated file in resourceSet: " + uri + " -> " + resource.getURI());
				resourceSet.getResource(uri, true);
			}
		
		//StringBuffer buff = new StringBuffer("Resourceset for project: " + projectName + "\r\n");
		//for (Resource resource:resourceSet.getResources())
		//	buff.append(resource.getURI() + "\r\n");
		//Logger.info(buff.toString());
		EcoreUtil.resolveAll(resourceSet);
		return resourceSet;
	}

	public XtextResourceSet buildResourceSet(String projectName) throws CoreException {
		
		Provider<XtextResourceSet> xtextResourceSetProvider = getInjector().getInstance(new Key<Provider<XtextResourceSet>>() {});

		XtextResourceSet resourceSet = xtextResourceSetProvider.get();
		if (resolveAll)
			resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		ResourceCollectorVisitor visitor = new ResourceCollectorVisitor(resourceSet);
		ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).accept( visitor,IContainer.PROJECT); 
		//ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).accept( visitor,IContainer.INCLUDE_HIDDEN | IContainer.DEPTH_INFINITE); 
		
		//URI uri = URI.createURI("archive:file:/home/jsantos/.m2/repository/com/poyake/poyake-file/0.0.4-SNAPSHOT/poyake-file-0.0.4-SNAPSHOT.jar!/metadata/common/table/StorageFile.metadata");
		//resourceSet.getResource(uri,  true);
		
		EcoreUtil.resolveAll(resourceSet);
		return resourceSet;
	}
	

	public class ResourceCollectorVisitor implements IResourceProxyVisitor{
		XtextResourceSet rSet;
		String projectName;


		public ResourceCollectorVisitor(XtextResourceSet rSet) {
			this.rSet=rSet;

		}

		public boolean visit (IResourceProxy proxy) throws CoreException {
			//System.out.println(proxy.requestResource().getFullPath());
			if (proxy.getName().endsWith(".metadata") || proxy.getName().contains(".metadata#")) {
				String platformUri2 = proxy.requestResource().getFullPath().toString();
				if (!platformUri2.startsWith("archive:file:"))  
					platformUri2 = "platform:/resource" + proxy.requestResource().getFullPath();
				//else
					//System.out.println("Archive file: " + platformUri2);
				//System.out.println("Getting resource: " + platformUri2);
				rSet.getResource(URI.createURI(platformUri2), true);
			}
			return true; 
		}

	}
	
	public static void logResourceList(XtextResourceSet rs) {
		for (Resource resource:rs.getResources()) {
			System.out.println(resource.getURI());
		}
	}

}
