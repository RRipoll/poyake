package com.jsantos.factory.appinfo;

import java.sql.SQLException;

public interface IAppInfoProvider extends IProvider{

	//Object get(String key) throws SQLException;

	//void set(String key, Object value) throws SQLException;
	
	Object get(String key, Integer inputUserGroupId) throws SQLException;

	void set(String key, Object value, Integer inputUserGroupId) throws SQLException;
	
	//Object getInputUserDefault();

}
