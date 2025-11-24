package com.jsantos.metadata.plugin.dbmanager.dbresetter;

import org.apache.commons.lang3.StringUtils;

public class ConnectionPreferences {
	boolean useEclipse;
	String eclipseConnectionProfile;
	String user;
	String password;
	String url;
	
	public boolean isUseEclipse() {
		return useEclipse;
	}
	public void setUseEclipse(boolean useEclipse) {
		this.useEclipse = useEclipse;
	}
	public String getEclipseConnectionProfile() {
		return eclipseConnectionProfile;
	}
	public void setEclipseConnectionProfile(String eclipseConnectionProfile) {
		this.eclipseConnectionProfile = eclipseConnectionProfile;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isEmpty(){
		if (StringUtils.isNotBlank(getUrl()))
			return false;
		if (StringUtils.isNotBlank(getEclipseConnectionProfile()))
			return false;
		return true;
	}
}
