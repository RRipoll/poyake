package com.etantolling.testrunner.test.core.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.etantolling.testrunner.test.core.metadata.MTField;
import com.etantolling.testrunner.test.utils.appcontext.MainDb;

public class ForeignKeyHelper {
	
	public static String getForeignKeyValue(MTField mtField, Integer foreignTablePk) throws SQLException{
		String retValue = null;
		
		if (null != mtField.getForeignKey())
			if (mtField.getForeignKey().getIsEnumeration())
				return mtField.getForeignKey().getEnumerationValue(foreignTablePk);
		
		if (null == foreignTablePk) return null;
		
		try(Connection conn = MainDb.getConnection()){
			Statement st = conn.createStatement();
			String sql = "select " + mtField.getForeignKey().getIdField().getName() + " from " + mtField.getForeignKey().getTableName() + " where " + mtField.getForeignKey().getPrimaryKey().getName() + " = ";
			sql += foreignTablePk.toString(); //todo: this should work for other data types apart from int.
			ResultSet rs = st.executeQuery(sql);
			if (rs.next())
				retValue = rs.getString(1);
			rs.close();
			st.close();
		}
		return retValue;
	}
}
