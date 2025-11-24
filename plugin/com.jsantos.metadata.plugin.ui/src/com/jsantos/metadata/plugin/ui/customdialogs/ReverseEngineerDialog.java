package com.jsantos.metadata.plugin.ui.customdialogs;

import java.sql.Connection;
import java.sql.SQLException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.jsantos.metadata.plugin.dbmanager.dbresetter.ConnectionManager;
import com.jsantos.metadata.plugin.dbmanager.dbresetter.ConnectionPreferences;
import com.jsantos.metadata.plugin.dbmanager.reverseengineer.DatabaseJDBCSchemaLoader;
import com.jsantos.metadata.plugin.metaDsl.Entity;
import com.jsantos.metadata.plugin.ui.grapheditor.ModelManager;

public class ReverseEngineerDialog extends Dialog{
	Composite container;
	ConnectionPreferences prefs;
	String projectName;
	DatabaseJDBCSchemaLoader loader;
	Table entityListTable; 
	
	public ReverseEngineerDialog(IShellProvider parentShell, ConnectionPreferences prefs, String projectName) throws SQLException, CoreException {
		super(parentShell);
		this.prefs = prefs;
		this.projectName = projectName;
		ConnectionManager connectionManager = new ConnectionManager(prefs); 
		Connection conn = connectionManager.getConnection();
		loader = new DatabaseJDBCSchemaLoader(conn, projectName, connectionManager.getVendor());
		loader.captureAllTables();
	}

	
    @Override
    protected Control createDialogArea(Composite parent) {
        container = (Composite) super.createDialogArea(parent);
        createTable(container);

        Button buttonSelectAll = new Button(container, SWT.None);
        buttonSelectAll.setText("Select All");
        buttonSelectAll.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				for (TableItem item:entityListTable.getItems())
					item.setChecked(true);
			}
		});
        
        Button buttonSelectNone = new Button(container, SWT.None);
        buttonSelectNone.setText("Remove All");
        buttonSelectNone.addListener(SWT.Selection, new Listener() {
			@Override
			public void handleEvent(Event event) {
				for (TableItem item:entityListTable.getItems())
					item.setChecked(false);
			}
		});

        return container;
    }
    
    void createTable(Composite composite) {
		entityListTable = new Table(composite, SWT.MULTI|SWT.V_SCROLL|SWT.CHECK );
		GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false, 5, 1);
		gd.heightHint=300;
		gd.minimumHeight=300;
		gd.minimumWidth=500;
		entityListTable.setLayoutData(gd);
		entityListTable.setHeaderVisible(true);
		entityListTable.setLinesVisible(true);
		new TableColumn(entityListTable, SWT.None);
		new TableColumn(entityListTable, SWT.None).setText("Package/Schema");
		new TableColumn(entityListTable, SWT.None).setText("Entity");
		for (Entity entity:loader.getEntities().values()) {
			TableItem item = new TableItem(entityListTable, SWT.None);
			item.setText(1, "");
			item.setText(2, entity.getName());
			item.setData(ModelManager.ENTITY, entity);
			item.setChecked(true);
		}
		for (int i=0; i<entityListTable.getColumnCount(); i++)
			entityListTable.getColumn(i).pack();
   }
    
	protected boolean isResizable() {
		return true;
	}


	@Override
	protected void cancelPressed() {
		super.cancelPressed();
	}


	@Override
	protected void okPressed() {
		for (TableItem item:entityListTable.getItems()) {
			if (item.getChecked())
				loader.getSelectedEntities().add((Entity)item.getData(ModelManager.ENTITY));
		}
		super.okPressed();
	}


	public DatabaseJDBCSchemaLoader getLoader() {
		return loader;
	}

	
}
