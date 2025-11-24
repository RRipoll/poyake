package com.jsantos.metadata.plugin.ui.handlers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.framework.FrameworkUtil;

import com.jsantos.metadata.plugin.dbmanager.dbresetter.ConnectionPreferences;
import com.jsantos.metadata.plugin.dbmanager.dbresetter.DBResetter;
import com.jsantos.metadata.plugin.ui.customdialogs.DBConnectionPreferencesDialog;
import com.jsantos.metadata.plugin.ui.internal.PluginActivator;
import com.jsantos.metadata.plugin.ui.util.UIUtil;

public class DBResetHandler extends AbstractHandler {
	private static final ILog LOGGER = Platform.getLog(FrameworkUtil.getBundle(DBResetHandler.class));
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		try {
			DBConnectionPreferencesDialog dialog = new DBConnectionPreferencesDialog(window.getShell(), DBConnectionPreferencesDialog.DBRESET);
		    dialog.open();

		    
		    IProject project = UIUtil.getProject(dialog.getProject());
		    
		    if (null == project) {
				MessageDialog.openInformation(window.getShell(),"com.jsantos.metadata.plugin.ui","No Project Selected, cancelling operation");
				return null;
		    }
		    
	    	project.build(IncrementalProjectBuilder.FULL_BUILD, null);
		    Visitor visitor = new Visitor();
		    project.accept(visitor,IContainer.DERIVED);
		    
			if (null == visitor.file) {
				MessageDialog.openError(window.getShell(),"com.jsantos.metadata.plugin.ui","Script file not found.");
				return null;
			}
	
				
			try (InputStream is = visitor.file.getContents()){
				String script = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
				new DBResetter().resetDB(dialog.getConnectionPreferences(), script);
				MessageDialog.openInformation(window.getShell(),"com.jsantos.metadata.plugin.ui","Database Reset completed");
			} 
		}
		catch (Throwable e) {
			e.printStackTrace();
			LOGGER.error("Error in ResetDB", e);
			MessageDialog.openError(window.getShell(),"com.jsantos.metadata.plugin.ui",e.getMessage() + " Exception Type: " + e.toString());
			
		}
		return null;
	}
	
	ConnectionPreferences readConnectionPreferences() {
		ConnectionPreferences prefs = new ConnectionPreferences();
		IPreferenceStore store = PluginActivator.getInstance().getPreferenceStore();
		prefs.setUrl(store.getString("jdbc url"));
		prefs.setPassword("jdbc password");
		prefs.setUser("jdbc username");
		return prefs;
	}
	
	class Visitor implements IResourceProxyVisitor{
		IFile file; 
		long modificationTimestamp = 0;
		
		@Override
		public boolean visit(IResourceProxy proxy) throws CoreException {
			if (proxy.getName().equals("DB_Creation_Script.sql")) {
				IResource resource = proxy.requestResource();
				if (resource instanceof IFile) {
					if (proxy.getModificationStamp()>modificationTimestamp) {
						file = (IFile)resource;
						modificationTimestamp = proxy.getModificationStamp();
					}
				}
				return true;
			}
			else
				return true;
		}
		
	}
}









