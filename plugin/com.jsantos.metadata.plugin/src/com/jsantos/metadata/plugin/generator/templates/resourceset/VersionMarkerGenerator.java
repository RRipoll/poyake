package com.jsantos.metadata.plugin.generator.templates.resourceset;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IFileSystemAccess;

public class VersionMarkerGenerator {
	public void generate (ResourceSet rs, IFileSystemAccess fsa) {
		StringBuffer buff = new StringBuffer("Meta files:\r\n");
		for (Resource resource:rs.getResources())
			buff.append(resource.getURI() + "\r\n");
		fsa.generateFile("sql/versionMarker.txt" , buff);

	}
}
