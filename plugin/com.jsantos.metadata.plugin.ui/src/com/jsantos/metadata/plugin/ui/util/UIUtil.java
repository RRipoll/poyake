package com.jsantos.metadata.plugin.ui.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

public class UIUtil {

	public static IProject getProject() throws CoreException {
		IProject retValue = null;

		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (null == activePage)
			return null;

		IEditorPart activeEditor = activePage.getActiveEditor();

		if (activeEditor != null) {
			IEditorInput input = activeEditor.getEditorInput();
			if (null != input) {
				retValue = input.getAdapter(IProject.class);
				if (retValue == null) {
					try {
						IResource resource = input.getAdapter(IResource.class);
						if (resource != null) {
							retValue = resource.getProject();
						}
					}catch (Throwable e) {}
				}
			}
		}

		int projectCount = 0;
		if (null == retValue) {
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
			for (IProject project:projects) {
				if (project.isOpen())
					if (null !=project.getNature("org.eclipse.xtext.ui.shared.xtextNature")) {
						retValue = project;
						projectCount++;
					}
			}
		}
		if (projectCount>1)
			throw new RuntimeException("Multiple open projects match criteria");

		return retValue;

	}
	
	public static IProject getProject(String projectName) {
		for (IProject project:ResourcesPlugin.getWorkspace().getRoot().getProjects()) 
			if (project.getName().equalsIgnoreCase(projectName))
				return project;
		return null;
	}
	
}
