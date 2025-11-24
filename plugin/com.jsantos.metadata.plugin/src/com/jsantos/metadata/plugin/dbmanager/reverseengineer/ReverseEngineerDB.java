package com.jsantos.metadata.plugin.dbmanager.reverseengineer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.SQLException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import com.jsantos.metadata.plugin.accessors.EntityHelper;
import com.jsantos.metadata.plugin.metaDsl.Entity;

public class ReverseEngineerDB {
	
	
	public static void reverseEngineer(DatabaseJDBCSchemaLoader loader, String projectName, String baseFolder) throws SQLException, CoreException {
		//DatabaseJDBCSchemaLoader loader = new DatabaseJDBCSchemaLoader(conn, projectName, vendor);
		loader.captureSchema();
		Serializer serializer = new Serializer();
		for (Entity entity:loader.getSelectedEntities()) {
			String folder = baseFolder + "/";
			if (null !=EntityHelper.getSchema(entity))
				folder += EntityHelper.getSchema(entity);
			createFile(projectName, folder, EntityHelper.getSimpleName(entity)+ ".metadata", serializer.serialize(entity));
		}
		
		IFolder viewsFolder = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getFolder(baseFolder + "/views/");
		if (!viewsFolder.exists()) viewsFolder.create(IResource.NONE, true, null);
		for (String viewFullName:loader.getViews().keySet()) {
			String schema = viewFullName.split("\\.")[0];
			String viewName = viewFullName.split("\\.")[1];
			String folder = baseFolder + "/views/" + schema + "/";
			createFile(projectName, folder, viewName + ".sql", loader.getViews().get(viewFullName));
		}
		
	}
	
	static void createFile(String projectName, String folderPath, String fileName, String fileContents) throws CoreException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		IFolder folder = project.getFolder(folderPath + "/");
		IFile file = folder.getFile(fileName);
		//at this point, no resources have been created
		if (!project.exists()) project.create(null);
		if (!project.isOpen()) project.open(null);
		if (!folder.exists()) 
		    folder.create(IResource.NONE, true, null);

		byte[] bytes = fileContents.getBytes();
	    InputStream source = new ByteArrayInputStream(bytes);
		if (!file.exists()) {
		    file.create(source, IResource.NONE, null);
		}
	}
	
}
