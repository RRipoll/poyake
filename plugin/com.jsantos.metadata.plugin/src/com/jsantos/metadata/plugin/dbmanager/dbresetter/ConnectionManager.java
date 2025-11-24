package com.jsantos.metadata.plugin.dbmanager.dbresetter;

import java.sql.Connection;
import java.sql.SQLException;

import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;

public class ConnectionManager {
	Connection conn;
	boolean bUsingEclipse = false;
	Vendor vendor = null;
	EclipseConnectionManager ecm = null;
	PluginConnectionManager pcm = null;

	public ConnectionManager(ConnectionPreferences prefs) throws SQLException {
		this.bUsingEclipse = prefs.isUseEclipse();
		if (this.bUsingEclipse) {
			ecm = new EclipseConnectionManager(prefs.getEclipseConnectionProfile());
			vendor = ecm.getVendor();
		}
		else {
			pcm = new PluginConnectionManager(prefs);
			vendor = pcm.getVendor();
		}
	}
	
	public Vendor getVendor() {
		return vendor;
	}
	
	public Connection getConnection() throws SQLException {
		if (null != conn)
			return conn;
		if (bUsingEclipse) {
			conn = ecm.connect();
			return conn;
		}
		else {
			return pcm.getConnection();
		}
	}
	
	void close() throws SQLException {
		if (null !=conn && !bUsingEclipse) {
			conn.close();
			conn = null;
		}
	}
}
