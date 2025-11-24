package com.etantolling.testrunner.test.core.facade.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Hashtable;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.etantolling.testrunner.test.core.config.EnvironmentHelper;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;
import com.etantolling.testrunner.test.utils.db.DBUtils;
import com.etantolling.testrunner.test.utils.db.NamedParameterStatement;

public class EventDefinitionDAO {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public Map<String, Object> getEventDef(String tableName, String dataRecordPk) throws SQLException {
		Hashtable<String, Object> hashTable = new Hashtable<String, Object>();
		String versionDate=EnvironmentHelper.getVersionDate();
		String sql = "select * from " + tableName + " where " + tableName + "ID = " + dataRecordPk + " and startdate<"+versionDate+" and enddate>="+versionDate+"";
		Connection conn = null;
		NamedParameterStatement nps = null;
		try {
			conn = MainDb.getTestConnection();
			nps = new NamedParameterStatement(conn, sql);
			ResultSet rs = nps.executeQuery();
			if (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					String columnName = rs.getMetaData().getColumnName(i);
					if(columnName.equalsIgnoreCase("STARTDATE") || columnName.equalsIgnoreCase("ENDDATE") )continue;
					if (rs.getMetaData().getColumnType(i) == Types.CLOB) {
						hashTable.put(columnName, DBUtils.CLOBToString(rs.getClob(i)));
					} else if (rs.getMetaData().getScale(i) > 0) {
						BigDecimal number = (BigDecimal) rs.getObject(i);
						if (number == null) {
							hashTable.put(columnName, "");
						}
						else {
							if (number.scale() == 0) {
								number = number.setScale(2);
							}
							hashTable.put(columnName, number);
						}
					} else {
						hashTable.put(columnName, rs.getObject(i) != null ? rs.getObject(i) : "");
					}
				}
			}
		} finally {
			if (nps != null) {
				nps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return hashTable;
	}
}
