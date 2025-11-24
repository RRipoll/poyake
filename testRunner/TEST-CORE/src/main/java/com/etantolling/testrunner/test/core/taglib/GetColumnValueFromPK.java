package com.etantolling.testrunner.test.core.taglib;

import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

import com.etantolling.testrunner.test.utils.db.DBUtils;

public class GetColumnValueFromPK {

	public static Object getColumnValueFromPK(java.lang.String column, String table, String pkField, Integer val) throws SQLException {

		if (!StringUtils.isBlank(column) && !StringUtils.isBlank(table) && !StringUtils.isBlank(pkField) && val != null) {

			String sql = "SELECT " + column + " FROM " + table + " WHERE " + pkField + " = " + val;
			return DBUtils.getSingleStringValue(sql);

		}
		return null;
	}
}
