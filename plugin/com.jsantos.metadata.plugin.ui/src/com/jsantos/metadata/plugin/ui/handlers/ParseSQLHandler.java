package com.jsantos.metadata.plugin.ui.handlers;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;

import com.jsantos.metadata.plugin.dbmanager.dbresetter.ConnectionManager;
import com.jsantos.metadata.plugin.dbmanager.dbresetter.ConnectionPreferences;
import com.jsantos.metadata.plugin.querymanager.QueryManager;
import com.jsantos.metadata.plugin.querymanager.dependencies.DependencyFileParser;
import com.jsantos.metadata.plugin.querymanager.entityrenderer.ViewAndQueryEntityRenderer;
import com.jsantos.metadata.plugin.querymanager.jdbcresolver.JDBCResolver;
import com.jsantos.metadata.plugin.querymanager.parser.SQLParser;
import com.jsantos.metadata.plugin.querymanager.resolver.Resolver;
import com.jsantos.metadata.plugin.ui.customdialogs.DBConnectionPreferencesDialog;
import com.jsantos.metadata.plugin.ui.util.MetaDslUtil;
import com.jsantos.metadata.plugin.ui.util.UIUtil;
import com.jsantos.metadata.plugin.util.Logger;

public class ParseSQLHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		IEditorPart editor = ((IWorkbenchPage) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()).getActiveEditor();
		IEditorInput input = (IEditorInput) editor.getEditorInput();


		IResource sqlFileResource = ((IFileEditorInput)input).getFile();
		IProject project = sqlFileResource.getProject();
		IPath folder = sqlFileResource.getParent().getProjectRelativePath();
		if (input instanceof FileEditorInput) {
			IFile file = ((FileEditorInput) input).getFile();

			if (!file.getName().endsWith(".sql")) {
				MessageDialog.openError(window.getShell(),"com.jsantos.metadata.plugin.ui","Error: This is not a sql file, operation will be cancelled.");
				return null;
			}


			try (InputStream is = file.getContents()){
				String sql = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
				ArrayList<IPath> dependencyFileLocations = new ArrayList<>();				
				SQLParser parser = new SQLParser();
				ConnectionPreferences prefs = MetaDslUtil.readConnectionPreferences(UIUtil.getProject().getName());
				if (null == prefs || prefs.isEmpty()) {
					DBConnectionPreferencesDialog dialog = new DBConnectionPreferencesDialog(window.getShell(), DBConnectionPreferencesDialog.DBRESET);
				    dialog.open();
				    prefs = dialog.getConnectionPreferences();
				    if (null == prefs || prefs.isEmpty()) {
						MessageDialog.openError(window.getShell(),"com.jsantos.metadata.plugin.ui","No connection preferences set, cancelling operation.");
				    	return null;
				    }	
				}
				ConnectionManager conManager = new ConnectionManager(prefs); 
				parser.parseSql(sql, conManager.getVendor());
				Resolver resolver = new Resolver(parser, project);
				resolver.resolveAll();
				if (!resolver.isFullyResolved()) {
					if (MessageDialog.openQuestion(window.getShell(), "Run against Database", "In order to find the type for some fields\r\nit is required to run the query or view against the database.\r\nThis assumes a database is configured and up to date\r\nRun?")) {
						Connection conn = conManager.getConnection();
						if (null != conn) {
							JDBCResolver jdbcResolver = new JDBCResolver();
							jdbcResolver.executeQuery(parser.getSelectStatement(), conn);
							resolver = new Resolver(parser, project);
							resolver.setJDBCResolver(jdbcResolver);
							try {
								resolver.resolveAll();
							}
							catch (SQLException e) {
								String resolverInfo = "Resolver Info: \r\n";
								resolverInfo += resolver.logInfo();
								resolverInfo += jdbcResolver.logInfo();
								System.out.println(resolverInfo);
								Logger.error(resolverInfo, e);
								throw e;
							}
						}
					}
				}
				if (parser.getFunctionDependencies().size()>0) {
					if (MessageDialog.openQuestion(window.getShell(), "Search for dependencies", "The view or query depends on other functions or views.\r\nIf this dependencies are created using a sql script file from this project\r\nSearch for them on the .sql files and link the sql file to the entity?")) {
						dependencyFileLocations = new DependencyFileParser().parseSqlFiles(project.getName(), parser.getFunctionDependencies());
					}
				}
				new QueryManager().logParserOutput(parser);
				String src =  ViewAndQueryEntityRenderer.render(resolver, parser, sqlFileResource, sql, dependencyFileLocations);

				String fileName ;
				if (null== parser.getViewName())
					fileName = FilenameUtils.removeExtension(sqlFileResource.getName()) + ".metadata";
				else
					fileName = parser.getViewName() + ".metadata";
				IFile newFile = createFile(src, fileName, project.getName(), folder, window);
				openEditor(newFile);
			} catch (Throwable e) {
				Logger.error("Exception while parsing sql file", e);
				e.printStackTrace();
				MessageDialog.openError(window.getShell(),"com.jsantos.metadata.plugin.ui","SQL syntax error:\r\n" + e.getMessage() + "\r\nException Type:" + e.toString());
				return null;
			}
		}



		return null;
	}

	IFile createFile(String fileContents, String fileName, String projectName, IPath folderPath, IWorkbenchWindow window) throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject project  = root.getProject(projectName);
		IFolder folder = project.getFolder(folderPath);
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
		else {
			if (MessageDialog.openConfirm(window.getShell(), "com.jsantos.metadata.plugin.ui", "File " + fileName + " already exist. Modify?"))
				file.setContents(source, true, true, null);
		}
		return file;
	}

	void openEditor(IFile file) throws PartInitException {
		String editorID = null;

		IEditorRegistry editorRegistry = PlatformUI.getWorkbench().getEditorRegistry();
		if (editorID == null || editorRegistry.findEditor(editorID) == null)
		{
			editorID = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getFullPath().toString()).getId();
		}

		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		page.openEditor(new FileEditorInput(file), editorID, true, IWorkbenchPage.MATCH_INPUT);		
	}

}
