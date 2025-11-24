package com.jsantos.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsantos.common.util.MapValues;
import com.jsantos.factory.permission.IPermissionProvider;
import com.jsantos.metadata.permission.EnuPermissionType;
import com.jsantos.metadata.permission.EnuPermissionValue;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.dbstatement.NamedParameterStatement;

public class PermissionProvider implements IPermissionProvider{

	@Override
	public boolean isImplemented() {
		return true;
	}

	
	@Override
	public  MapValues<Integer> getPermissions(Object Id) throws SQLException {
		MapValues<Integer> retValues = new MapValues<Integer>();

		String sql = 	" select DISTINCT rolId, permissionId, permissionTypeId, 3 permissionValueId, shortCode, description " + 
						" from permission.Vpermission where shortCode not in ( "	+ 
							" select DISTINCT shortCode from permission.Vpermission where inputusergroupId = :INPUTUSERGROUPID  ) "	+ 
							" union  select  rolId, permissionId, permissionTypeId, permissionValueId, shortCode, description " + 
							" from permission.Vpermission where inputusergroupId = :INPUTUSERGROUPID";
		
		try (Connection conn = MainDb.getConnection();NamedParameterStatement nps = new NamedParameterStatement(conn, sql)) {
			

			nps.setInt("INPUTUSERGROUPID", (Integer)Id);
			ResultSet rs = nps.executeQuery();

			while (rs.next()) {
				retValues.add(rs.getString("shortCode"), rs.getInt("permissionValueId"));
			}

		}
		return retValues;
	}
	
	
	
	

	@Override
	public Integer getPermissionType(String permissionType) {
		switch (permissionType) {
		case "MENU":
			return EnuPermissionType.MENU;
		case "MTTABLE":
			return EnuPermissionType.MTTABLE;
		default:
			break;
		}
		return EnuPermissionType.MTTABLE;
	}


	@Override
	public boolean canRead(Object permission) {
		if(null==permission)return true;
		return ((Integer)permission)==EnuPermissionValue.READ || ((Integer)permission)==EnuPermissionValue.WRITE ||((Integer)permission)==EnuPermissionValue.ALL;
	}


	@Override
	public boolean canWrite(Object permission) {
		if(null==permission)return true;
		return ((Integer)permission)==EnuPermissionValue.WRITE ||((Integer)permission)==EnuPermissionValue.ALL;
			
	}


	@Override
	public boolean hasAnyPermission(Object permission) {
		if(null==permission)return true;
		return ((Integer)permission)!=EnuPermissionValue.NO;
		
	}


	@Override
	public boolean hasAllPermission(Object permission) {
		if(null==permission)return true;
		return ((Integer)permission)==EnuPermissionValue.ALL;
	}
	
}
