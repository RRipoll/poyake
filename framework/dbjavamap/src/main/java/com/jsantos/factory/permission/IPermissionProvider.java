package com.jsantos.factory.permission;

import java.sql.SQLException;

import com.jsantos.common.util.MapValues;
import com.jsantos.factory.appinfo.IProvider;

public interface IPermissionProvider  extends IProvider{
	public boolean isImplemented();

	MapValues<Integer> getPermissions(Object Id) throws SQLException;

	//Integer getPermissionValue(Object permissionTypeDescription);

	boolean canRead(Object permission);
	
	boolean canWrite(Object permission);
	
	boolean hasAnyPermission(Object permission);
	
	boolean hasAllPermission(Object permission);
	
	Integer getPermissionType(String permissionType);
}
