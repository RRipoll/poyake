package com.jsantos.metadata.plugin.dbmanager.tests;

import java.sql.SQLException;

import org.eclipse.datatools.connectivity.IConnection;
import org.eclipse.datatools.connectivity.IConnectionProfile;
import org.eclipse.datatools.connectivity.IManagedConnection;
import org.eclipse.datatools.connectivity.ProfileManager;
import org.eclipse.datatools.connectivity.sqm.core.connection.ConnectionInfo;
import org.eclipse.datatools.connectivity.sqm.core.rte.DDLGenerator;
import org.eclipse.datatools.connectivity.sqm.internal.core.RDBCorePlugin;
import org.eclipse.datatools.modelbase.sql.schema.Catalog;
import org.eclipse.datatools.modelbase.sql.schema.Database;
import org.eclipse.datatools.modelbase.sql.schema.SQLObject;
import org.eclipse.datatools.modelbase.sql.schema.Schema;
import org.eclipse.datatools.modelbase.sql.tables.Table;
import org.eclipse.emf.common.util.EList;

public class LoadCatalog {
	
	public void test(String connectionProfile) throws SQLException {
		IConnectionProfile profile = ProfileManager.getInstance().getProfileByName(connectionProfile);
		
		RDBCorePlugin.getDefault().getDatabaseDefinitionRegistry().getDefinition("MySql", "5.1");
		//MySqlCatalogDatabase db = new MySqlCatalogDatabase(new ConnectionManager(connectionProfile).connect());	
		DDLGenerator generator= RDBCorePlugin.getDefault().getDatabaseDefinitionRegistry().getDefinition("MySql", "5.1").getDDLGenerator();
		
		Database db = getDatabase(profile, true);
//		EList<Catalog> catalogs = db.getCatalogs();
		EList<Schema> schemas = db.getSchemas();
		
		for(Schema schema:schemas) {
			System.out.println("Schema: " + schema.getName());
			EList<Table> tables = schema.getTables();
			for (Table table:tables) {
				//SQLObject[] objects = new SQLObject[1];
				
				String[] statements = generator.generateDDL((SQLObject[])tables.toArray(new SQLObject[tables.size()]), null);
				for (String statement:statements)
					System.out.println(statement);
				
			}
		}
	
	}
	
    public static Database getDatabase(IConnectionProfile profile, boolean connect)
    {
        try {
            IManagedConnection mc = profile.getManagedConnection(ConnectionInfo.class.getName());
            //during the profile connected event notification, 
            //IManagedConnection is connected while IConnectionProfile is not 
            if (mc == null || !mc.isConnected())
            {
                if (connect)
                {
                    profile.connect();
                    mc = profile.getManagedConnection(ConnectionInfo.class.getName());
                }
                else
                {
                    return null;
                }
            }
            if (mc != null) {
	            IConnection ic = mc.getConnection();
	            if (ic == null)
	            {
	                return null;
	            }
	            Object rawConn = ic.getRawConnection();
	            if (rawConn instanceof ConnectionInfo)
	            {
	                ConnectionInfo ci = (ConnectionInfo)rawConn;
	                return ci.getSharedDatabase();
	            }
            }
            else {
            	//EditorCorePlugin.getDefault().log(NLS.bind(Messages.ProfileUtil_error_no_managed_connection, databaseIdentifier.getProfileName()));
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
