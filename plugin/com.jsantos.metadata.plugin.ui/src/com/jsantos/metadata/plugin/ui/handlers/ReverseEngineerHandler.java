package com.jsantos.metadata.plugin.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.e4.ui.di.UISynchronize;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.inject.Inject;
import com.jsantos.metadata.plugin.dbmanager.reverseengineer.ReverseEngineerDB;
import com.jsantos.metadata.plugin.ui.customdialogs.DBConnectionPreferencesDialog;
import com.jsantos.metadata.plugin.ui.customdialogs.ReverseEngineerDialog;
import com.jsantos.metadata.plugin.util.Logger;

public class ReverseEngineerHandler   extends AbstractHandler {
	@Inject UISynchronize sync;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		Shell shell = window.getShell();

		try {
			DBConnectionPreferencesDialog connectionPrefsDialog = new DBConnectionPreferencesDialog(window.getShell(), DBConnectionPreferencesDialog.REVERSE_ENGINEER); 
			//ReverseEngineerDBDialog dialog = new ReverseEngineerDBDialog(window.getShell());
		    connectionPrefsDialog.open();
		    
			if (null == connectionPrefsDialog.getConnectionPreferences()) {
				MessageDialog.openError(
						window.getShell(),
						"com.jsantos.metadata.plugin.ui",
						"No connection profile or project selected. Cancelling operation");
	
				return null;
			}

			ReverseEngineerDialog reverseEngineerDialog = new ReverseEngineerDialog(window, connectionPrefsDialog.getConnectionPreferences(), connectionPrefsDialog.getProject());
			if (Window.OK == reverseEngineerDialog.open()) {
				ReverseEngineerDB.reverseEngineer(reverseEngineerDialog.getLoader(), connectionPrefsDialog.getProject(), connectionPrefsDialog.getFolder());
			
				/*
				Job job = Job.create("Reverse engineer DB: " + dialog.getConnectionPreferences().getUrl(), (ICoreRunnable) monitor -> {
					try {
						ConnectionPreferences prefs = dialog.getConnectionPreferences();
						ConnectionManager connectionManager = new ConnectionManager(prefs); 
						Connection conn = connectionManager.getConnection();
						new ReverseEngineerDB().reverseEngineer(dialog.getProject(), dialog.getFolder(), conn, connectionManager.getVendor());
					} catch (Throwable e) {
						Logger.error("Error in Reverse Engineer", e);
						e.printStackTrace();
					};
		
				});
				
				job.schedule();
				*/
				
				MessageDialog.openInformation(
						shell,
						"com.jsantos.metadata.plugin.ui",
						"Reverse Engineer completed ");
	
			}
		}
		catch (Throwable e) {
			e.printStackTrace();
			Logger.error("Error in Database reverse engineer" + e);
			MessageDialog.openError(shell, "com.jsantos.metadata.plugin.ui",e.toString());
		}
		return null;
	}

}
