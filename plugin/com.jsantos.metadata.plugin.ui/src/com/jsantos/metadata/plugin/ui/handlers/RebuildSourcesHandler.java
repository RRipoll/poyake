package com.jsantos.metadata.plugin.ui.handlers;

import java.util.Vector;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.jsantos.metadata.plugin.ui.builder.BuildStateManager;

public class RebuildSourcesHandler  extends AbstractHandler {
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		try {
			forceRebuild();
		} catch (CoreException e) {
			e.printStackTrace();
			throw new ExecutionException(e.getMessage());
		}
		return null;
	}

	public void forceRebuild() throws CoreException {
		Vector<IProject> projects = new Vector<>();
		ResourcesPlugin.getWorkspace().getRoot().accept( new IResourceProxyVisitor() {
			
			public boolean visit(IResourceProxy proxy) throws CoreException {
				if (proxy.getName().endsWith(".metadata")) {
					IResource resource = proxy.requestResource();
					if (!projects.contains(resource.getProject()))
						projects.add(resource.getProject());
					resource.touch(null);
					/*
					IWorkspace workspace = ResourcesPlugin.getWorkspace();
					IWorkspaceRoot root = workspace.getRoot();
					resource.touch(null);
					IFile file = root.getFileForLocation(resource.getLocation());
					String originalSource = new BufferedReader(new InputStreamReader(file.getContents())).lines().collect(Collectors.joining("\n"));
					String tmpSource = originalSource + "//this is a hack";
					file.setContents(new ByteArrayInputStream(tmpSource.getBytes()), true, true, null);
					file.setContents(new ByteArrayInputStream(originalSource.getBytes()), true, true, null);
					*/
					return true;
				}
				return true;
			}
		},IContainer.PROJECT);
		
		ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.CLEAN_BUILD, null);
//		for (IProject project:projects)
//			BuildStateManager.forceBuilt(project);
	}
	
}
