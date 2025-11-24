package com.jsantos.custom.trigger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsantos.metadata.MTAuditData;
import com.jsantos.orm.MainDb;
import com.jsantos.orm.dbstatement.IDetachedRecord;
import com.jsantos.orm.dbstatement.NamedParameterStatement;
import com.jsantos.orm.exceptions.ApiError;
import com.jsantos.orm.exceptions.ApiException;
import com.jsantos.orm.mt.MTField;
import com.jsantos.orm.mt.MTTrigger;

public class PermissionTrigger extends MTTrigger {

	@Override
	public void beforeInsert(IDetachedRecord dr) {
        
		if(dr.getTable().isRecorder())return;
		MTField mTinputUserId = dr.findFieldByname(MTAuditData.INPUTUSER.INPUTUSERID.getName());
		if (null != mTinputUserId) {
			Integer inputUserId = dr.getInt(mTinputUserId);

			Connection conn = MainDb.getConnection();

				String sql = " select DISTINCT" + " rolId," + " permissionId," + " permissionTypeId," + " 0 permissionValueId,"
						+ " shortCode" + " from permission.Vpermission" + " where permissionId not in ("
						+ " select permissionId from permission.Vpermission where inputuserId = :INPUTUSERID ) and permissionTypeId=3 and shortCode=:SHORTCODE"
						+ " " + " union " + " select " + " rolId," + " permissionId," + " permissionTypeId,"
						+ " permissionValueId," + " shortCode" + " from permission.Vpermission"
						+ " where inputuserId = :INPUTUSERID and permissionTypeId=3 and shortCode=:SHORTCODE ";

				NamedParameterStatement nps;
				try {
					nps = new NamedParameterStatement(conn, sql);
					nps.setInt("INPUTUSERID", inputUserId);
					nps.setString("SHORTCODE", dr.getTable().getTableName());
					ResultSet rs = nps.executeQuery();
					if (rs.next()) {
						Integer permissionValueID = rs.getInt("permissionValueId");
						if (permissionValueID != 2)
							throw new ApiException(ApiError.NOT_ALLOWED);
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
		}
	}
	
	@Override
	public void beforeUpdate(IDetachedRecord dr) {
		beforeInsert(dr);
	}
}
