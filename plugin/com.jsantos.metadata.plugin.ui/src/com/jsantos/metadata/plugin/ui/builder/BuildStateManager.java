package com.jsantos.metadata.plugin.ui.builder;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;

public class BuildStateManager {
	static ArrayList<IProject> fullyBuiltProjects = new ArrayList<>();
	
	public static void ensureBuilt(IProject project) throws CoreException {
		if (null != project) {
			if (!fullyBuiltProjects.contains(project)) {
				project.build(IncrementalProjectBuilder.FULL_BUILD, null);
				fullyBuiltProjects.add(project);
			}
		}
	}

	public static void forceBuilt(IProject project) throws CoreException {
		project.build(IncrementalProjectBuilder.FULL_BUILD, null);
		fullyBuiltProjects.add(project);
		
	}

}
