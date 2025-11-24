package com.jsantos.metadata.plugin.dbmanager.dbresetter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;

public class PluginConnectionManager {
	String user;
	String password;
	String url;
	String driverClass;
	Vendor vendor;

	public PluginConnectionManager(ConnectionPreferences prefs){
		user = prefs.getUser();
		password = prefs.getPassword();
		url = prefs.getUrl();

		if (url.toLowerCase().contains("postgresql")) {
			vendor = Vendor.POSTGRESQL;
			driverClass = "org.postgresql.Driver";
		}
		if (url.toLowerCase().contains(":h2:")) {
			vendor = Vendor.H2;
			driverClass = "org.h2.Driver";
		}

	}

	Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public void registerDriver() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Vendor getVendor() {
		return vendor;
	}

}
