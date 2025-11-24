package com.jsantos.metadata.plugin.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class TestDatabaseConnectionHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		/*
		ConnectionPreferences prefs = MetaDslUtil.readConnectionPreferences(UIUtil.getProject().getName());
		if (null == prefs) {
			ConnectionProfileSelectionDialog dialog = new ConnectionProfileSelectionDialog(window.getShell());
		    dialog.open();
		    connectionProfile = MetaDslUtil.getConnectionProfile();
		    
			if (StringUtils.isEmpty(connectionProfile)) {
				MessageDialog.openError(
						window.getShell(),
						"com.jsantos.metadata.plugin.ui",
						"No connection profile found. Please set one in the Database Connection section of MetaDsl in the preferences window");
	
				return null;
			}
		}

		//new EclipseDataToolsModelCreator().test();
		//new LoadCatalog().test(connectionProfile);
		
		try {
			Connection conn = new EclipseConnectionManager(connectionProfile).connect();
			if (conn!=null)
				MessageDialog.openInformation(
						window.getShell(),
						"com.jsantos.metadata.plugin.ui",
						"Testing Database connection: \r\nSuccess ");
		} catch (SQLException e) {
			e.printStackTrace();
		};
		*/
		
		return null;
	}
	
}
