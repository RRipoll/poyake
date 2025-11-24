package com.jsantos.metadata.plugin.ui.util;

import org.eclipse.jface.preference.IPreferenceStore;

import com.jsantos.metadata.plugin.dbmanager.dbresetter.ConnectionPreferences;
import com.jsantos.metadata.plugin.ui.internal.PluginActivator;

public class MetaDslUtil {
	
	static public ConnectionPreferences readConnectionPreferences(String projectName) {
		IPreferenceStore prefStore = PluginActivator.getInstance().getPreferenceStore();
		if (null == prefStore.getString(projectName + ".DatabaseSettings"))
			return null;
		ConnectionPreferences prefs = new ConnectionPreferences();
		prefs.setUseEclipse(prefStore.getBoolean(projectName + ".useDatabaseConnectionProfile" ));
		prefs.setEclipseConnectionProfile(prefStore.getString(projectName + ".databaseConnectionProfile"));
		prefs.setUrl(prefStore.getString(projectName + ".jdbcUrl"));
		prefs.setUser(prefStore.getString(projectName + ".jdbcUser"));
		prefs.setPassword(prefStore.getString(projectName + ".jdbcPassword"));
		return prefs;
	}
	
	static public void saveConnectionPreferences(String projectName, ConnectionPreferences prefs) {
		IPreferenceStore prefStore = PluginActivator.getInstance().getPreferenceStore();
		prefStore.setValue(projectName + ".useDatabaseConnectionProfile", prefs.isUseEclipse());
		prefStore.setValue(projectName + ".DatabaseSettings", "True");
		
		if (null != prefs.getEclipseConnectionProfile() )
			prefStore.setValue(projectName + ".databaseConnectionProfile", prefs.getEclipseConnectionProfile());
		if (null != prefs.getUrl() )
			prefStore.setValue(projectName + ".jdbcUrl", prefs.getUrl());
		if (null != prefs.getUser() )
			prefStore.setValue(projectName + ".jdbcUser", prefs.getUser());
		if (null != prefs.getPassword())
			prefStore.setValue(projectName + ".jdbcPassword", prefs.getPassword());
	}
}
