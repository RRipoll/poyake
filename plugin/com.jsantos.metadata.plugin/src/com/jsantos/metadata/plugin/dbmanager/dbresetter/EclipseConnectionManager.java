package com.jsantos.metadata.plugin.dbmanager.dbresetter;


import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.datatools.connectivity.IConnection;
import org.eclipse.datatools.connectivity.IConnectionProfile;
import org.eclipse.datatools.connectivity.IManagedConnection;
import org.eclipse.datatools.connectivity.ProfileManager;

import com.jsantos.metadata.plugin.generator.templates.resourceset.dbcreationscript.Vendor;

public class EclipseConnectionManager {
	String connectionProfile = null;
	private String  providerName;
	private IConnectionProfile profile;
	
	public EclipseConnectionManager(String connectionProfile) throws SQLException {
		if(StringUtils.isEmpty(connectionProfile))
			throw new SQLException("Connection profile is empty, please set a connection profile in preferences window. (Preferences->MetaDsl ->Database Connection");
		this.connectionProfile=connectionProfile;
		profile = ProfileManager.getInstance().getProfileByName(connectionProfile);
		if (null==profile)
			throw new SQLException("No profile found for Profile Name " + connectionProfile);
		providerName = profile.getProviderName();
	}
	
	public java.sql.Connection connect() throws SQLException {
		IStatus status = profile.connect();
		if (status.getCode() == IStatus.OK) {
			IManagedConnection managedConnection = profile.getManagedConnection ("java.sql.Connection");
			if (managedConnection != null) {
				IConnection connection = managedConnection.getConnection();
				return (java.sql.Connection) connection.getRawConnection();
			}
			throw new SQLException("Coudn't connect to database");
		} 
		else {
			if (status.getException() != null) {
				status.getException().printStackTrace();
			}
			throw new SQLException("Coudn't connect to database");
		} 
	}

	
	
	public String getProviderName() {
		return providerName;
	}

	public Vendor getVendor() {
		for (Vendor vendor:Vendor.values()) {
			if (vendor.getEclipseConnectionManagerVendorString().equalsIgnoreCase(providerName))
				return vendor;
		}
		return Vendor.DEFAULT;
	}
}
